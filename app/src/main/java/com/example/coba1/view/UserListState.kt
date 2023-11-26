package com.example.coba1.view

import com.example.coba1.data.entity.UserEntity

sealed class UserListState {
    object Loading : UserListState()

    data class Succes(val userData: List<UserEntity>) : UserListState()

}