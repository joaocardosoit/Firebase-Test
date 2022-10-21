package com.example.firebasetest.data

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.example.firebasetest.listeners.UsersListener
import com.example.firebasetest.models.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class UsersRepository {
    private var listener: UsersListener? = null
    val database = Firebase.database
    val myRef = database.getReference("https://console.firebase.google.com/project/fir-test-a167c/firestore/data/~2FUsers~2F6fsXL5m7wQ6JdKcD62r4")

    //Write a user in database
    fun writeInDatabase(user: User){
        myRef.setValue(user)
    }

    //Read all data values
    fun readDatabase(){
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value = dataSnapshot.getValue<String>()
                Log.d(TAG, "Value is: $value")
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })
    }

    fun registerListener(listener: UsersListener, context: Context){
        this.listener = listener
    }
}