package com.example.androidpractical.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.databinding.ActivityMvpLogInBinding
import com.example.androidpractical.interfaces.Contract
import com.example.androidpractical.presenter.Presenter

class MvpLogInActivity : AppCompatActivity(), Contract.View {

    private lateinit var binding: ActivityMvpLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val presenter = Presenter(this)

        binding.btnLogIn.setOnClickListener {
            presenter.doLogIn(binding.etEmail.text.toString(), binding.etPassword.text.toString())
        }
    }

    override fun onSuccess(message: String) {
        printMessage(message)
    }

    override fun onFailure(message: String) {
        printMessage(message)
    }

    private fun printMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}