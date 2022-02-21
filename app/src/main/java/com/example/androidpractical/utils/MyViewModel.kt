package com.example.androidpractical.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val textData = MutableLiveData("Empty !!!")

    fun getText(): MutableLiveData<String> {
        return textData
    }

    fun setText(text: String) {
        textData.value = text
    }
}