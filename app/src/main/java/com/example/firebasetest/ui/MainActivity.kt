package com.example.firebasetest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firebasetest.R
import com.example.firebasetest.databinding.ActivityMainBinding
import com.example.firebasetest.utils.NavigationManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
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