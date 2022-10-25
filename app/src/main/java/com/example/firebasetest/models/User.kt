package com.example.firebasetest.models

import android.content.Context
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(val userId: String, val email: String, val password: String): Parcelable