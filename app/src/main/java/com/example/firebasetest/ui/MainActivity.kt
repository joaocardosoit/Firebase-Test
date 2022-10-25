package com.example.firebasetest.ui

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebasetest.data.UsersRepository
import com.example.firebasetest.databinding.ActivityMainBinding
import com.example.firebasetest.models.User
import com.example.firebasetest.utils.NavigationManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth
    }

    override fun onStart() {
        super.onStart()
        NavigationManager.goToFirstMenu(supportFragmentManager)
        val currentUser = auth.currentUser
        if (currentUser != null){
            reload()
        }
    }

    private fun reload(){

    }
}