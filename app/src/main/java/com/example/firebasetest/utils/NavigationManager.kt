package com.example.firebasetest.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.firebasetest.R
import com.example.firebasetest.ui.HomeFragment
import com.example.firebasetest.ui.LoginFragment
import com.example.firebasetest.ui.RegisterFragment

object NavigationManager {

    private fun placeFragment(fm: FragmentManager, fragment: Fragment){
        val transition = fm.beginTransaction()
        transition.replace(R.id.frame, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    fun goToHomeMenu(fm: FragmentManager){
        placeFragment(fm, HomeFragment())
    }

    fun goToLoginMenu(fm: FragmentManager){
        placeFragment(fm, LoginFragment())
    }

    fun goToRegisterMenu(fm: FragmentManager){
        placeFragment(fm, RegisterFragment())
    }
}