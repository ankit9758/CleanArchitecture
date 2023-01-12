package com.example.cleanarchitecturedemo.features_cart.data.remote

import com.example.cleanarchitecturedemo.core.AppConstants
import com.example.cleanarchitecturedemo.features_cart.data.remote.dto.CartDto
import retrofit2.Response
import retrofit2.http.GET

interface CartService {
    @GET(AppConstants.CART_LIST)
    suspend fun getRemoteCartData(): Response<List<CartDto>>
}