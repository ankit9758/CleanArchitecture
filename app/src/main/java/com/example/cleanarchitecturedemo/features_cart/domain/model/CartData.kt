package com.example.cleanarchitecturedemo.features_cart.domain.model

data class CartData(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<ProductData>,
    val rating: RatingData,
    val userId: Int
)