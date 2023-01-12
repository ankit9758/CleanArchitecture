package com.example.cleanarchitecturedemo.features_cart.domain.use_case

import com.example.cleanarchitecturedemo.core.Resource
import com.example.cleanarchitecturedemo.features_cart.domain.model.CartData
import com.example.cleanarchitecturedemo.features_cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow

class CartListUserCase(private val cartRepository: CartRepository) {
    fun getCartData(): Flow<Resource<List<CartData>>> {
        return cartRepository.getCartListData()
    }
}