package com.example.cleanarchitecturedemo.feature_user.data.remote.dto

import com.example.cleanarchitecturedemo.feature_user.domain.model.NameData

data class NameDataDto(
    val first_name: String,
    val last_name: String
){
    fun toNameData(): NameData {
        return NameData(
            first_name = first_name,
            last_name = last_name
        )
    }
}