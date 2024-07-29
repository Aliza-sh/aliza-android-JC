package com.aliza.alizaandroidJC

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val repository = UserRepository()

    //CRUD user
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        _users.value = repository.getUsers()
    }

    fun addUser(newUser: User) {
        _users.value = repository.addUser(newUser)
    }

    //textField
    private val _textFieldValue = MutableLiveData<String>()
    val textFieldValue: LiveData<String> = _textFieldValue

    fun textFieldChangedText(newValue: String) {
        _textFieldValue.value = newValue
    }

}