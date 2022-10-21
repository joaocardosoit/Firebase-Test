package com.example.firebasetest.models

val listaUsers = mutableListOf<User>()
data class User(val email: String, val password: String) {

    /*fun onLogin(user: User){
        for (i in 0..listaUsers.size){
            if (listaUsers[i].email == email && listaUsers[i].password){

            }
        }
    }*/

    fun onCreateUser(user: User){
        listaUsers.add(user)
    }
}