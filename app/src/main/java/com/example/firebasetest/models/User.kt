package com.example.firebasetest.models

import android.content.Context
import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(var userId: String, val email: String, val password: String): Parcelable