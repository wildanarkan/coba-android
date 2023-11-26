package com.example.coba1.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coba1.data.entity.UserEntity


@Dao
interface AppDao {

    @Query("SELECT * FROM user")
    fun getAllUser(): List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(data: UserEntity)
}