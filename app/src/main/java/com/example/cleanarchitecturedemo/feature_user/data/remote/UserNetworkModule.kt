package com.example.cleanarchitecturedemo.feature_user.data.remote

import com.example.cleanarchitecturedemo.core.RetrofitNew
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserNetworkModule {
    @Singleton
    @Provides
    fun provideApiService(@RetrofitNew retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}