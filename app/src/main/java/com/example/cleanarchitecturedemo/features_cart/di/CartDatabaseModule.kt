package com.example.cleanarchitecturedemo.features_cart.di

import android.app.Application
import androidx.room.Room
import com.example.cleanarchitecturedemo.core.GsonParser
import com.example.cleanarchitecturedemo.feature_user.data.local.Converters
import com.example.cleanarchitecturedemo.features_cart.data.local.CartConverters
import com.example.cleanarchitecturedemo.features_cart.data.local.CartDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CartDatabaseModule {
    @Provides
    @Singleton
    fun provideCartDatabase(app: Application): CartDatabase {
        return Room.databaseBuilder(
            app, CartDatabase::class.java, "cart_db"
        ).addTypeConverter(CartConverters(GsonParser(Gson()))).build()
    }

    @Provides
    @Singleton
    fun provideCartDao(cartDatabase: CartDatabase)= cartDatabase.getCartDao()
}