package com.example.firebasetest.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.firebasetest.R
import com.example.firebasetest.ui.HomeFragment
import com.example.firebasetest.ui.LoginFragment

object NavigationManager {

    private fun placeFragment(fm: FragmentManager, fragment: Fragment){
        val transition = fm.beginTransaction()
        transition.replace(R.id.frame, fragment)
        transition.addToBackStack(null)
        transition.commit()
    }

    fun goToMainMenu(fm: FragmentManager){
        placeFragment(fm, HomeFragment())
    }

    fun goToLoginMenu(fm: FragmentManager){
        placeFragment(fm, LoginFragment())
    }
}