package com.example.cleanarchitecturedemo.features_cart.data.remote.dto

import com.example.cleanarchitecturedemo.features_cart.data.local.entity.CartEntity

data class CartDto(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<ProductDto>,
    val rating: RatingDto,
    val userId: Int
) {
    fun convertToCartEntity(): CartEntity {
        return CartEntity(
            __v, date, id, products = products.map { it.convertToProductData() },
            rating = rating.convertToRatingData(),
            userId
        )
    }

}