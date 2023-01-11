package com.example.cleanarchitecturedemo.feature_user.presentation

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecturedemo.feature_user.core.Resource
import com.example.cleanarchitecturedemo.feature_user.domain.state.UserListState
import com.example.cleanarchitecturedemo.feature_user.domain.use_case.UserListUserCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val userListUserCase: UserListUserCase):ViewModel() {
    private val _userListState = MutableStateFlow(UserListState())
     val userListState = _userListState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()
    init {
        getUserListData()
    }
   private fun getUserListData() {
        viewModelScope.launch {
            userListUserCase.getUser()
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _userListState.value = userListState.value.copy(
                                userList = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _userListState.value = userListState.value.copy(
                                userList = result.data ?: emptyList(),
                                isLoading = false
                            )
                            _eventFlow.emit(UIEvent.ShowSnackBar(
                                result.message ?: "Unknown error"
                            ))
                        }
                        is Resource.Loading -> {
                            _userListState.value = userListState.value.copy(
                                userList = result.data ?: emptyList(),
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