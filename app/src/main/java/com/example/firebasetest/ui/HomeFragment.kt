package com.example.firebasetest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.firebasetest.R
import com.example.firebasetest.databinding.FragmentHomeBinding
import com.example.firebasetest.databinding.FragmentLoginBinding
import com.example.firebasetest.listeners.UsersListener
import com.example.firebasetest.viewmodel.UserViewModel

class HomeFragment : Fragment(), UsersListener {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewmodel: UserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)
        viewmodel = ViewModelProvider(this).get(UserViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title = "Home Page"
        context?.let { viewmodel.registerListener(this, it) }

        binding.buttonRead.setOnClickListener {
            viewmodel.readData()
        }
    }

}