package com.example.firebasetest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.firebasetest.R
import com.example.firebasetest.databinding.FragmentLoginBinding
import com.example.firebasetest.databinding.FragmentRegisterBinding
import com.example.firebasetest.utils.NavigationManager
import com.example.firebasetest.viewmodel.UserViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding
    private lateinit var viewModel: UserViewModel
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_register, container, false)
        binding = FragmentRegisterBinding.bind(view)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Register"

        binding.buttonRegister.setOnClickListener {
            if (binding.editPasswordRegister.text.toString().equals(binding.editConfirmPassword.text.toString())){
                registerUser(binding.editEmailRegister.text.toString(), binding.editPasswordRegister.text.toString())
            } else {
                binding.editConfirmPassword.error = "Please, confirm your password"
            }
        }
    }

    override fun onStart() {
        super.onStart()
        auth = Firebase.auth
    }

    private fun registerUser(email: String, password: String){
        if(email.isNotEmpty() && password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(MainActivity()){ task ->
                    if (task.isSuccessful){
                        activity?.supportFragmentManager?.let { NavigationManager.goToRegisterMenu(it) }
                        Toast.makeText(activity, "User add sucessfully", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(activity, task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                }
        } else if(email.isEmpty()){
            binding.editEmailRegister.error = "Email cannot be empty"
            //Toast.makeText(activity, "Email and password cannot be empty", Toast.LENGTH_SHORT).show()
        } else if (password.isEmpty()){
            binding.editPasswordRegister.error = "Password cannot be empty"
        }
    }
}