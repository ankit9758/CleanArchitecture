package com.example.cleanarchitecturedemo.feature_user.presentation

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
import com.example.cleanarchitecturedemo.databinding.ActivityMainBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var viewModel: UserViewModel
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpViewModel()
        setupObservers()
        setErrorObserver()
    }

    private fun setErrorObserver() {
        lifecycleScope.launchWhenStarted {
            viewModel.eventFlow.collect {
                 toast(it.toString())
            }
        }
    }

    private fun setUpViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
    }


    private fun setupObservers() {
        lifecycleScope.launchWhenResumed {
            viewModel.userListState.collect {
                if(it.isLoading){
                  binding.progressCircular.show()
                }else{
                    binding.progressCircular.hide()
                    Log.d("TAG-----",Gson().toJson(it.userList))
                }

            }


        }
    }
}