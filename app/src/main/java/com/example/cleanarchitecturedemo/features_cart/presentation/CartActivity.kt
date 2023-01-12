package com.example.cleanarchitecturedemo.features_cart.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.core.hide
import com.example.cleanarchitecturedemo.core.show
import com.example.cleanarchitecturedemo.core.toast
import com.example.cleanarchitecturedemo.databinding.ActivityCartBinding
import com.example.cleanarchitecturedemo.feature_user.presentation.UserViewModel
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCartBinding
    private lateinit var viewModel:CartViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        setUpViewModel()
        setupObservers()
        setErrorObserver()
    }

    private fun setUpViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart)
        viewModel = ViewModelProvider(this)[CartViewModel::class.java]
    }



private fun setErrorObserver() {
    lifecycleScope.launchWhenStarted {
        viewModel.eventFlow.collect {
            toast(it.toString())
        }
    }
}



private fun setupObservers() {
    lifecycleScope.launchWhenResumed {
        viewModel.cartListState.collect {
            if(it.isLoading){
                binding.progressCircular.show()
            }else{
                binding.progressCircular.hide()
                Log.d("TAG-----",Gson().toJson(it.cartList))
            }

        }


    }
}
}