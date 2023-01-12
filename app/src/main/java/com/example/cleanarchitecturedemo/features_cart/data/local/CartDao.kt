package com.example.cleanarchitecturedemo.features_cart.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecturedemo.features_cart.data.local.entity.CartEntity

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCartListData(user: List<CartEntity>)

    @Query("SELECT * FROM Cart")
    fun getAllCartData(): List<CartEntity>

}