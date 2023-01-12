package com.example.cleanarchitecturedemo.features_cart.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cleanarchitecturedemo.features_cart.data.local.entity.CartEntity
@TypeConverters(CartConverters::class)
@Database(entities = [CartEntity::class], version = 1)
abstract class CartDatabase:RoomDatabase() {
    abstract fun getCartDao(): CartDao
}