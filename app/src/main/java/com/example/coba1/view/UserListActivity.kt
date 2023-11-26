package com.example.coba1.view

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.livedata.observeAsState
import com.example.coba1.view.widget.userListScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListActivity : ComponentActivity() {
    private val viewModel: UserListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            when (val dataState =
                viewModel.userListState.observeAsState(initial = UserListState.Loading).value) {
                UserListState.Loading -> Log.d("wildan", "Loading")
                is UserListState.Succes -> {
                    userListScreen(data = dataState.userData)
                }
            }
        }
        viewModel.getData()
    }
}