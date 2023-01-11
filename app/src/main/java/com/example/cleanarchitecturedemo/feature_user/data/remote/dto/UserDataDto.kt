package com.example.cleanarchitecturedemo.feature_user.data.remote.dto

import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData

data class UserDataDto(
    val body: String,
    val id: Int,
    val nameData: List<NameDataDto>,
    val title: String,
    val userId: Int
) {
    fun toUserData(): UserData {
        return UserData(
            body = body,
            id = id,
            nameData = nameData.map { it.toNameData() },
            title,
            userId
        )
    }
}