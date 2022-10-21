package com.example.firebasetest.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import com.example.firebasetest.data.UsersRepository
import com.example.firebasetest.listeners.UsersListener
import com.example.firebasetest.models.User

class UserViewModel(application: Application): AndroidViewModel(application) {

    private val usersRepository = UsersRepository()

    fun readData(){
        usersRepository.readDatabase()
    }

    fun writeData(user: User){
        usersRepository.writeInDatabase(user)
    }

    fun onLogin(user: User): User{
        return user
    }

    fun registerListener(listener: UsersListener, context: Context){
        usersRepository.registerListener(listener, context)
    }
}