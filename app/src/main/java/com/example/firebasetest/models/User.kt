package com.example.firebasetest.models

import android.content.Context
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(val email: String, val password: String): Parcelable