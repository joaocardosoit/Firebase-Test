package com.example.firebasetest.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.firebasetest.models.User

class UserViewModel(application: Application): AndroidViewModel(application) {

    fun onLogin(user: User): User{
        return user
    }
}