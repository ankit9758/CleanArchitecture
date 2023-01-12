package com.example.cleanarchitecturedemo.features_cart.domain.state
import com.example.cleanarchitecturedemo.features_cart.domain.model.CartData

data class CartListState(
    val cartList: List<CartData> = emptyList(),
    val isLoading: Boolean = false
)
