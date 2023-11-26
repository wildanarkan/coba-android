package com.example.coba1.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coba1.data.AppDao
import com.example.coba1.data.entity.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userListState = MutableLiveData<UserListState>(UserListState.Loading)
    val userListState: LiveData<UserListState> = _userListState

    fun getData() {
        test()
//        getAllUser()
    }

    private fun test(){
        viewModelScope.launch(Dispatchers.IO) {
            for (i in 1..20){
                userRepository.insertUser(
                    UserEntity(
                        userId = i,
                        userName = "nama ke $i",
                        userAddress = "Alamat ke $i"

                    )
                )
            }

            delay(5000)

            val data = userRepository.getAllUser().sortedBy {
                it.userId
            }

            _userListState.postValue(
                UserListState.Succes(data)
            )
        }
    }
    private fun getAllUser() {
        viewModelScope.launch(Dispatchers.IO) {

        }

    }
}