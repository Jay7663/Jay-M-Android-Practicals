package com.example.androidpractical.interfaces

interface ILogInView {
    //Methods to implement on Activity Side
    fun onMVCSuccess(message: String)
    fun onMVCFailure(message: String)
}