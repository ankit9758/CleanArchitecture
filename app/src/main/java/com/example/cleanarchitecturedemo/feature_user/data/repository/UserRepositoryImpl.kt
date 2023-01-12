package com.example.cleanarchitecturedemo.feature_user.data.repository

import com.example.cleanarchitecturedemo.core.Resource
import com.example.cleanarchitecturedemo.feature_user.data.local.UserDao
import com.example.cleanarchitecturedemo.feature_user.data.remote.ApiService
import com.example.cleanarchitecturedemo.feature_user.domain.model.UserData
import com.example.cleanarchitecturedemo.feature_user.domain.repository.UserRepository
import kotlinx.coroutines.flow.*
import retrofit2.HttpException
import java.io.IOException

class UserRepositoryImp( private val api: ApiService,private val userDao: UserDao): UserRepository {
    override fun getUserList(): Flow<Resource<List<UserData>>> = flow{
        emit(Resource.Loading())
//        val userList=userDao.getAllUser().map { it.toUser() }
//        emit(Resource.Loading(data = userList))
        try {
            val remoteUserData= api.getRemoteUserData()
            userDao.addUserListData(remoteUserData.body()?.map { it.toUserData() }?: emptyList())
         // emit(Resource.Success(remoteUserData.body()?.map { it.toUserData() }))
        } catch(e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = null
            ))
        } catch(e: IOException) {
            emit(Resource.Error(
                message = "Couldn't reach server, check your internet connection.",
                data = null
            ))
        }
        val updatedUserList=userDao.getAllUser().map { it.toUser() }
        emit(Resource.Success(updatedUserList))
    }
}