package com.example.cleanarchitecturedemo.features_cart.di

import com.example.cleanarchitecturedemo.feature_user.domain.repository.UserRepository
import com.example.cleanarchitecturedemo.feature_user.domain.use_case.UserListUserCase
import com.example.cleanarchitecturedemo.features_cart.data.local.CartDao
import com.example.cleanarchitecturedemo.features_cart.data.local.CartDatabase
import com.example.cleanarchitecturedemo.features_cart.data.remote.CartService
import com.example.cleanarchitecturedemo.features_cart.data.repository.CartRepositoryImpl
import com.example.cleanarchitecturedemo.features_cart.domain.repository.CartRepository
import com.example.cleanarchitecturedemo.features_cart.domain.use_case.CartListUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CartRepositoryModule {
    @Singleton
    @Provides
    fun provideCartRepository(cartService: CartService,cartDao: CartDao):CartRepository{
        return CartRepositoryImpl(cartService,cartDao)
    }
    @Provides
    @Singleton
    fun provideCartListCase(cartRepository: CartRepository): CartListUserCase {
        return CartListUserCase(cartRepository)
    }
}