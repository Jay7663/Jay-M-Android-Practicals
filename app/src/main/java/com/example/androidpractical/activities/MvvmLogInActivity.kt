package com.example.androidpractical.activities

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.databinding.ActivityMvvmLogInBinding
import com.example.androidpractical.viewmodels.LogInViewModel

class MvvmLogInActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMvvmLogInBinding
    private val loginViewModel: LogInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.loginViewModel = loginViewModel

        loginViewModel.message.observe(this) {
            printMessage(it)
        }
        loginViewModel.upperCaseText.observe(this) {
            binding.tvUpperCase.text = it
        }
    }

    private fun printMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}