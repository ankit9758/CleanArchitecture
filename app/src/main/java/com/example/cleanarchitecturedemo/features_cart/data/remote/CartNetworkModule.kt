package com.example.cleanarchitecturedemo.features_cart.data.remote

import com.example.cleanarchitecturedemo.core.RetrofitNew
import com.example.cleanarchitecturedemo.feature_user.data.remote.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class CartNetworkModule {
    @Singleton
    @Provides
    fun provideCartService(@RetrofitNew retrofit: Retrofit): CartService {
        return retrofit.create(CartService::class.java)
    }
}