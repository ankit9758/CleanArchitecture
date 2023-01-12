package com.example.cleanarchitecturedemo.features_cart.domain.repository

import com.example.cleanarchitecturedemo.core.Resource
import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData
import com.example.cleanarchitecturedemo.features_cart.domain.model.CartData
import kotlinx.coroutines.flow.Flow

interface CartRepository {
    fun getCartListData(): Flow<Resource<List<CartData>>>
}