package com.example.cleanarchitecturedemo.feature_user.domain.use_case

import com.example.cleanarchitecturedemo.feature_user.core.Resource
import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData
import com.example.cleanarchitecturedemo.feature_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserListUserCase(private val userRepository: UserRepository) {

     fun getUser(): Flow<Resource<List<UserData>>> {
        return userRepository.getUserList()
    }
}