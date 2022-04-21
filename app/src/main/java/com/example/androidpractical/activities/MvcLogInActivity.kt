package com.example.androidpractical.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.controllers.LogInController
import com.example.androidpractical.databinding.ActivityMvcLogInBinding
import com.example.androidpractical.interfaces.ILogInView

class MvcLogInActivity : AppCompatActivity(), ILogInView {

    private lateinit var binding: ActivityMvcLogInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val logInController = LogInController(this)

        binding.btnLogIn.setOnClickListener {
            logInController.onLogIn(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
        }
    }

    override fun onMVCSuccess(message: String) {
        printMessage(message)
    }

    override fun onMVCFailure(message: String) {
        printMessage(message)
    }

    private fun printMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}