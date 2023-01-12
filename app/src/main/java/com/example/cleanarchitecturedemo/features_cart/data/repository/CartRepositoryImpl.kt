package com.example.cleanarchitecturedemo.features_cart.data.repository

import com.example.cleanarchitecturedemo.core.Resource
import com.example.cleanarchitecturedemo.features_cart.data.local.CartDao
import com.example.cleanarchitecturedemo.features_cart.data.remote.CartService
import com.example.cleanarchitecturedemo.features_cart.domain.model.CartData
import com.example.cleanarchitecturedemo.features_cart.domain.repository.CartRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class CartRepositoryImpl(private val cartService: CartService,private val cartDao: CartDao):CartRepository {
    override fun getCartListData(): Flow<Resource<List<CartData>>> = flow{
        emit(Resource.Loading())
        val cartList=cartDao.getAllCartData().map { it.convertToCartData() }
        emit(Resource.Loading(data = cartList))
        try {
            val remoteUserData= cartService.getRemoteCartData()
            cartDao.addCartListData(remoteUserData.body()?.map { it.convertToCartEntity() }?: emptyList())
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
        val updatedUserList=cartDao.getAllCartData().map { it.convertToCartData() }
        emit(Resource.Success(updatedUserList))
    }

}