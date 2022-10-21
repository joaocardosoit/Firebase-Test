package com.example.firebasetest.ui

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.firebasetest.R
import com.example.firebasetest.databinding.FragmentLoginBinding
import com.example.firebasetest.utils.NavigationManager
import com.example.firebasetest.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(view)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth

        binding.buttonLogin.setOnClickListener{
            registerUser(binding.editEmail.text.toString(), binding.editPassword.text.toString())
        }



        /*auth.signInWithEmailAndPassword(binding.editEmail.text.toString(), binding.editPassword.text.toString())
            .addOnCompleteListener(MainActivity()) { task ->
                if (task.isSuccessful){
                    val user = auth.currentUser
                    updateUI(user)
                }
            }*/
    }

    private fun updateUI(user: FirebaseUser?) {

    }

    private fun registerUser(email: String, password: String){
        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity()){ task ->
                    if (task.isSuccessful){
                        activity?.supportFragmentManager?.let { NavigationManager.goToMainMenu(it) }
                        Toast.makeText(activity, "User add sucessfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(activity, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }



}