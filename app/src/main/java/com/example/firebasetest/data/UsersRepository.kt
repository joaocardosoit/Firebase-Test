package com.example.firebasetest.data

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.example.firebasetest.listeners.UsersListener
import com.example.firebasetest.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class UsersRepository {
    private val auth: FirebaseAuth = Firebase.auth
    private var listener: UsersListener? = null
    val database = Firebase.database
    val myRef = database.getReferenceFromUrl("https://fir-test-a167c-default-rtdb.firebaseio.com/")
    private val user: FirebaseUser? = auth.currentUser
    private val userId = user?.uid

    //Write a user in database
    fun writeInDatabase(user: User){
        myRef.child("users").child(userId!!).push().setValue(user)
    }

    //Read all data values
    fun readDatabase(){
        myRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user = dataSnapshot.getValue<User>()
                assert(user != null)
                Log.d(TAG, "Value is: ${user!!.email}  ${user.password}")
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