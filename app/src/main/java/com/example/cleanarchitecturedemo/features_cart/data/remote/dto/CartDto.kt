package com.example.cleanarchitecturedemo.features_cart.data.remote.dto

data class CartDto(
    val __v: Int,
    val date: String,
    val id: Int,
    val products: List<ProductDto>,
    val rating: RatingDto,
    val userId: Int
)