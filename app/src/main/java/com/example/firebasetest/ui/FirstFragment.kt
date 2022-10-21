package com.example.firebasetest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.firebasetest.R
import com.example.firebasetest.databinding.FragmentFirstBinding
import com.example.firebasetest.utils.NavigationManager


class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        binding = FragmentFirstBinding.bind(view)
        (activity as AppCompatActivity).supportActionBar?.hide()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Click to go to Login screen
        binding.buttonFirstLogin.setOnClickListener {
            activity?.supportFragmentManager?.let { NavigationManager.goToLoginMenu(it) }
        }

        //Click to go to Register screen
        binding.buttonFirstRegister.setOnClickListener {
            activity?.supportFragmentManager?.let { NavigationManager.goToRegisterMenu(it) }
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }

}