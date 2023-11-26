package com.example.coba1.view.widget

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.coba1.data.entity.UserEntity
import com.example.coba1.view.UserListState

@Composable
fun userListScreen(
    data: List<UserEntity>
) {
    LazyColumn{
        items(
            items = data,
        ) {
            UserListItem(nama = it.userName)
        }
    }
}

@Composable
fun UserListItem(
    nama: String
){
    Row {
        Text(text = nama)
    }
}