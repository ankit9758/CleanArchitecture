package com.example.cleanarchitecturedemo.feature_user.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.cleanarchitecturedemo.core.JsonParser
import com.example.cleanarchitecturedemo.feature_user.domain.model.NameData

import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters (private val jsonParser: JsonParser){

    @TypeConverter
    fun fromNameToJson(json: String): List<NameData> {
        return jsonParser.fromJson<ArrayList<NameData>>(
            json,
            object : TypeToken<ArrayList<NameData>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toNameJson(meanings: List<NameData>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<NameData>>(){}.type
        ) ?: "[]"
    }


//    @TypeConverter
//    fun userNameListToJson(value: List<NameData>?) = Gson().toJson(value)
//
//    @TypeConverter
//    fun jsonToUserList(value: String) = Gson().fromJson(value, Array<NameData>::class.java).toList()
}