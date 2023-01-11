package com.example.cleanarchitecturedemo.feature_user.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.cleanarchitecturedemo.R
import com.example.cleanarchitecturedemo.databinding.ActivityMainBinding
import com.example.cleanarchitecturedemo.feature_user.core.Resource
import com.example.cleanarchitecturedemo.feature_user.domain.state.UserListState
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
    }

    private fun setUpViewModel() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
    }


    private fun setupObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.userListState.collect {
                    Log.d("TAG-----",Gson().toJson(it.userList))
            }
        }
    }
}