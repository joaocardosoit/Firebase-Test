package com.example.firebasetest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.firebasetest.R
import com.example.firebasetest.databinding.FragmentLoginBinding
import com.example.firebasetest.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth

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



        /*auth.signInWithEmailAndPassword(binding.editEmail.text.toString(), binding.editPassword.toString()){

        }*/
        println(binding.editEmail.toString())
    }


}