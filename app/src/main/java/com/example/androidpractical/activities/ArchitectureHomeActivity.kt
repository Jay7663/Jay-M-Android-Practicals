package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.databinding.ActivityArchitectureHomeBinding


class ArchitectureHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityArchitectureHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArchitectureHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMvc.setOnClickListener {
            startActivity(Intent(this, MvcLogInActivity::class.java))
        }

        binding.btnMvp.setOnClickListener {
            startActivity(Intent(this, MvpLogInActivity::class.java))
        }

        binding.btnMvvm.setOnClickListener {
            startActivity(Intent(this, MvvmLogInActivity::class.java))
        }
    }
}