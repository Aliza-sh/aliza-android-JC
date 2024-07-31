package com.aliza.alizaandroidJC.lazy_basic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LazyBasicViewModel : ViewModel() {

    private val repository = UserRepository()

    init {
        viewModelScope.launch {
            delay(300)
            loadUsers()
            loadTopUsers()
        }
    }

    private val _topUsers = MutableLiveData<List<User>>()
    val topUsers: LiveData<List<User>> = _topUsers

    private fun loadTopUsers() {
        _topUsers.value = repository.getTopUsers()
    }

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    private fun loadUsers() {
        _users.value = repository.getUsers()
    }
}