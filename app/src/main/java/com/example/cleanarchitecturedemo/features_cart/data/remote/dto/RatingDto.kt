package com.example.cleanarchitecturedemo.features_cart.data.remote.dto
import com.example.cleanarchitecturedemo.features_cart.domain.model.RatingData

data class RatingDto(
    val count: Int,
    val rate: Double
){
    fun convertToRatingData(): RatingData {
        return RatingData(count,rate)
    }
}