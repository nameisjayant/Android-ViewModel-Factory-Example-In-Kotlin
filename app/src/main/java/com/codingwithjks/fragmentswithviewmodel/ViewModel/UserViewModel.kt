package com.codingwithjks.fragmentswithviewmodel.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codingwithjks.fragmentswithviewmodel.Model.User
import com.codingwithjks.fragmentswithviewmodel.Repository.UserRepository

class UserViewModel(private val userRepository: UserRepository) : ViewModel() {
    val userMutableLiveData:MutableLiveData<List<User>>  = MutableLiveData()

    fun getData()
    {
        val response=userRepository.getUserData()
        userMutableLiveData.value=response
    }
}