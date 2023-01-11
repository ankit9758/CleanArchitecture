package com.example.cleanarchitecturedemo.feature_user.di

import com.example.cleanarchitecturedemo.feature_user.data.remote.ApiService
import com.example.cleanarchitecturedemo.feature_user.data.repository.UserRepositoryImp
import com.example.cleanarchitecturedemo.feature_user.domain.repository.UserRepository
import com.example.cleanarchitecturedemo.feature_user.domain.use_case.UserListUserCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserRepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService):UserRepository{
        return UserRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideUserUseListCase(userRepository: UserRepository):UserListUserCase{
        return UserListUserCase(userRepository)
    }
}