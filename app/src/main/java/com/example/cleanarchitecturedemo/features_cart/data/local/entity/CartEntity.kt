package com.example.cleanarchitecturedemo.features_cart.data.local.entity

import android.media.Rating
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cleanarchitecturedemo.features_cart.domain.model.CartData
import com.example.cleanarchitecturedemo.features_cart.domain.model.ProductData
import com.example.cleanarchitecturedemo.features_cart.domain.model.RatingData

@Entity(tableName = "Cart")
data class CartEntity(
    val __v: Int,
    val date: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val products: List<ProductData>,
    @Embedded val rating: RatingData,
    val userId: Int
){
  fun convertToCartData():CartData{
      return CartData(__v = __v,date,id, products = products, rating = rating,userId=userId)
  }
}