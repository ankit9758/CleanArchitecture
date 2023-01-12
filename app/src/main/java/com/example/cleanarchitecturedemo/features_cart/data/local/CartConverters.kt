package com.example.cleanarchitecturedemo.features_cart.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.cleanarchitecturedemo.core.JsonParser
import com.example.cleanarchitecturedemo.feature_user.domain.model.NameData
import com.example.cleanarchitecturedemo.features_cart.domain.model.ProductData
import com.example.cleanarchitecturedemo.features_cart.domain.model.RatingData
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class CartConverters(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromProductDataToJson(json: String): List<ProductData> {
        return jsonParser.fromJson<ArrayList<ProductData>>(
            json,
            object : TypeToken<ArrayList<ProductData>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toProductDataJson(meanings: List<ProductData>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<ProductData>>(){}.type
        ) ?: "[]"
    }

}