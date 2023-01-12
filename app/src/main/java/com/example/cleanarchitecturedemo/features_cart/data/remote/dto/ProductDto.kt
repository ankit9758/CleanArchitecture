package com.example.cleanarchitecturedemo.features_cart.data.remote.dto

import com.example.cleanarchitecturedemo.features_cart.domain.model.ProductData

data class ProductDto(
    val productId: Int,
    val quantity: Int
) {
    fun convertToProductData():ProductData{
       return ProductData(productId,quantity)
    }
}