package com.example.cleanarchitecturedemo.feature_user.data.remote

import com.example.cleanarchitecturedemo.core.AppConstants
import com.example.cleanarchitecturedemo.feature_user.data.remote.dto.UserDataDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(AppConstants.USER_LIST)
    suspend fun getRemoteUserData(): Response<List<UserDataDto>>
}