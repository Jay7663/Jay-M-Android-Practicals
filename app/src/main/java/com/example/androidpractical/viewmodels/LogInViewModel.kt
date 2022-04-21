package com.example.androidpractical.viewmodels

import android.util.Patterns
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidpractical.utils.CommonFunctions
import com.example.androidpractical.utils.Constants.ALL_FIELDS_ARE_REQUIRED
import com.example.androidpractical.utils.Constants.IMAGE_URL
import com.example.androidpractical.utils.Constants.NEED_STRONG_PASSWORD
import com.example.androidpractical.utils.Constants.SUCCESS
import com.example.androidpractical.utils.Constants.WRONG_EMAIL

class LogInViewModel : ViewModel() {

    var emailAddress = MutableLiveData<String>()
    var password = MutableLiveData<String>()
    var upperCaseText = MutableLiveData<String>()
    var message = MutableLiveData<String>()
    var profilePicture = MutableLiveData(IMAGE_URL)

    fun onLogInClick() {
        if (emailAddress.value?.isEmpty() == true || password.value?.isEmpty() == true) {
            message.value = ALL_FIELDS_ARE_REQUIRED
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress.value.toString()).matches()) {
            message.value = WRONG_EMAIL
        } else if (!CommonFunctions.isValidPassword(password.value.toString())) {
            message.value = NEED_STRONG_PASSWORD
        } else {
            message.value = SUCCESS
        }
    }
}