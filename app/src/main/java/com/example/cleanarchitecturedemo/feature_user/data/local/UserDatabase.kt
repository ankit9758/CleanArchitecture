package com.example.cleanarchitecturedemo.feature_user.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cleanarchitecturedemo.feature_user.data.local.entity.UserEntity
@Database(entities = [UserEntity::class], version = 2)
@TypeConverters(Converters::class)
abstract class UserDatabase:RoomDatabase() {
    abstract fun getUserDao():UserDao
}