package com.example.cleanarchitecturedemo.feature_user.domain.state

import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData

data class UserListState(
    val userList: List<UserData> = emptyList(),
    val isLoading: Boolean = false
)