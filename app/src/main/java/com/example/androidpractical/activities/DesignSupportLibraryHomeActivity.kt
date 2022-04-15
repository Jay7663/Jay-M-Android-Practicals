package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.databinding.ActivityDesignSupportLibraryHomeBinding

class DesignSupportLibraryHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDesignSupportLibraryHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDesignSupportLibraryHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavigationView.setOnClickListener {
            startActivity(Intent(this, NavigationViewHomeActivity::class.java))
        }

        binding.btnCoordinatorScroll.setOnClickListener {
            startActivity(Intent(this, CoordinatorScrollActivity::class.java))
        }

        binding.btnTabBar.setOnClickListener {
            startActivity(Intent(this, ViewPagerWithTabActivity::class.java))
        }

        binding.btnTextFields.setOnClickListener {
            startActivity(Intent(this, MaterialTextFieldsActivity::class.java))
        }

    }
}