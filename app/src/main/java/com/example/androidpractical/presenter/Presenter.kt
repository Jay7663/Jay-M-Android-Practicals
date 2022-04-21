package com.example.androidpractical.presenter

import android.util.Patterns
import com.example.androidpractical.interfaces.Contract
import com.example.androidpractical.utils.CommonFunctions
import com.example.androidpractical.utils.Constants.ALL_FIELDS_ARE_REQUIRED
import com.example.androidpractical.utils.Constants.MVP_SUCCESS
import com.example.androidpractical.utils.Constants.NEED_STRONG_PASSWORD
import com.example.androidpractical.utils.Constants.WRONG_EMAIL

class Presenter(private var view: Contract.View): Contract.Presenter {
    override fun doLogIn(email: String, password: String) {
        if (email.isEmpty() || password.isEmpty()) {
            view.onFailure(ALL_FIELDS_ARE_REQUIRED)
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            view.onFailure(WRONG_EMAIL)
        } else if (!CommonFunctions.isValidPassword(password)) {
            view.onFailure(NEED_STRONG_PASSWORD)
        } else {
            view.onSuccess(MVP_SUCCESS)
        }
    }
}