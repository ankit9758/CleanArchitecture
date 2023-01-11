package com.example.cleanarchitecturedemo.feature_user.domain.repository

import com.example.cleanarchitecturedemo.feature_user.core.Resource
import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUserList(): Flow<Resource<List<UserData>>>
}