package com.example.cleanarchitecturedemo.feature_user.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturedemo.feature_user.data.local.entity.UserEntity


@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUserListData(user: List<UserEntity>)

    @Query("SELECT * FROM User")
    fun getAllUser(): List<UserEntity>
}