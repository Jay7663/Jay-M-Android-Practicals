package com.example.androidpractical.interfaces

interface Contract {
    interface View {
        fun onSuccess(message: String)
        fun onFailure(message: String)
    }

    interface Presenter {
        fun doLogIn(email: String, password: String)
    }
}