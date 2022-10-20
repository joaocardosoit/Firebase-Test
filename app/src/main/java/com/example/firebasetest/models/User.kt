package com.example.firebasetest.models

data class User(val email: String, val password: String) {

    fun onLogin(user: User){
        //confirme login and do it
    }
}