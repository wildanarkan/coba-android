package com.example.coba1.view

import com.example.coba1.data.AppDao
import com.example.coba1.data.entity.UserEntity
import javax.inject.Inject
import javax.inject.Singleton
import javax.sql.CommonDataSource

@Singleton
class UserRepository @Inject constructor(
    private val localDataSource: AppDao
) {
    fun insertUser(data: UserEntity) = localDataSource.insertUser(data)
    fun getAllUser() = localDataSource.getAllUser()
}