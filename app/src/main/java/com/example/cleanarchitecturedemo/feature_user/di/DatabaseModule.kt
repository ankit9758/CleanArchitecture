package com.example.cleanarchitecturedemo.feature_user.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitecturedemo.core.GsonParser
import com.example.cleanarchitecturedemo.feature_user.data.local.Converters
import com.example.cleanarchitecturedemo.feature_user.data.local.UserDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideWordInfoDatabase(app: Application): UserDatabase {
        return Room.databaseBuilder(
            app, UserDatabase::class.java, "user_db"
        ).addTypeConverter(Converters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDatabase:UserDatabase)= userDatabase.getUserDao()
}