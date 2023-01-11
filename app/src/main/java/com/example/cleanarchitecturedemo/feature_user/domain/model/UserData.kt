package com.example.cleanarchitecturedemo.feature_user.domain.model

import com.example.cleanarchitecturedemo.feature_user.data.remote.dto.NameDataDto

data class UserData(
    val body: String,
    val id: Int,
    val nameData: List<NameData>,
    val title: String,
    val userId: Int
)
