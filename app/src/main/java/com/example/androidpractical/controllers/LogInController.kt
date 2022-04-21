package com.example.androidpractical.controllers

import android.util.Patterns
import com.example.androidpractical.interfaces.ILogInController
import com.example.androidpractical.interfaces.ILogInView
import com.example.androidpractical.utils.CommonFunctions
import com.example.androidpractical.utils.Constants.ALL_FIELDS_ARE_REQUIRED
import com.example.androidpractical.utils.Constants.MVC_SUCCESS
import com.example.androidpractical.utils.Constants.NEED_STRONG_PASSWORD
import com.example.androidpractical.utils.Constants.WRONG_EMAIL

class LogInController(val context: ILogInView) : ILogInController {
    override fun onLogIn(email: String, password: String) {
        // Operations with server and on Return of result
        if (email.isEmpty() || password.isEmpty()) {
            context.onMVCFailure(ALL_FIELDS_ARE_REQUIRED)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            context.onMVCFailure(WRONG_EMAIL)
        } else if (!CommonFunctions.isValidPassword(password)) {
            context.onMVCFailure(NEED_STRONG_PASSWORD)
        } else {
            context.onMVCSuccess(MVC_SUCCESS)
        }
    }
}