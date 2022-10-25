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
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.firebasetest.R
import com.example.firebasetest.databinding.FragmentLoginBinding
import com.example.firebasetest.listeners.UsersListener
import com.example.firebasetest.models.User
import com.example.firebasetest.utils.NavigationManager
import com.example.firebasetest.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment(),  UsersListener{

    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var auth: FirebaseAuth


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding = FragmentLoginBinding.bind(view)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.show()
        (activity as AppCompatActivity).supportActionBar?.title = "Welcome"
        context?.let { viewModel.registerListener(this, it) }
    }

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth

        //Verify if user is authenticated
        val currentUser = auth.currentUser
        /*if (currentUser != null){
            activity?.supportFragmentManager?.let { NavigationManager.goToHomeMenu(it) }
        }*/

        //User goes on
        binding.buttonLogin.setOnClickListener{
            signUser(binding.editEmail.text.toString(), binding.editPassword.text.toString())
        }
    }

    //Throw user info to firebase db
    private fun signUser(email: String, password: String){
        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity()){ task ->
                    if(task.isSuccessful){
                        activity?.supportFragmentManager?.let { NavigationManager.goToHomeMenu(it) }
                        Toast.makeText(activity, "Login was sucessfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
        } else if(email.isEmpty()){
            binding.editEmail.error = "Email cannot be empty"
            //Toast.makeText(activity, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
        } else if (password.isEmpty()){
            binding.editPassword.error = "Password cannot be empty"
        }
    }
}