package com.example.cleanarchitecturedemo.features_cart.presentation

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturedemo.core.Resource
import com.example.cleanarchitecturedemo.features_cart.domain.state.CartListState
import com.example.cleanarchitecturedemo.features_cart.domain.use_case.CartListUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartUseCase: CartListUserCase):ViewModel(){
    private val _cartListState = MutableStateFlow(CartListState())
    val cartListState = _cartListState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    init {
        getUserListData()
    }
    private fun getUserListData() {
        viewModelScope.launch {
            cartUseCase.getCartData().flowOn(Dispatchers.IO)
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _cartListState.value = cartListState.value.copy(
                                cartList = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _cartListState.value = cartListState.value.copy(
                                cartList = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _eventFlow.emit(UIEvent.ShowSnackBar(
                                result.message ?: "Unknown error"
                            ))
                        }
                        is Resource.Loading -> {
                            _cartListState.value = cartListState.value.copy(
                                cartList = result.data ?: emptyList(),
                                isLoading = true
                            )
                        }
                    }
                }.launchIn(this)
        }
    }
    sealed class UIEvent {
        data class ShowSnackBar(val message: String): UIEvent()
    }
}