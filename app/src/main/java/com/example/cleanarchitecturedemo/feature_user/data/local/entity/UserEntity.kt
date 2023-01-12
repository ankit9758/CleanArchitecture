package com.example.cleanarchitecturedemo.feature_user.data.local.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.cleanarchitecturedemo.feature_user.domain.model.NameData
import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData

@Entity(tableName = "User")
data class UserEntity(
    val body: String,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val nameData: List<NameData>,
    val title: String,

    val userId: Int
){
    fun toUser(): UserData {
        return UserData(
            body = body,
            id = id,
            title = title?:"",
            userId = userId, nameData = nameData
        )
    }
}
