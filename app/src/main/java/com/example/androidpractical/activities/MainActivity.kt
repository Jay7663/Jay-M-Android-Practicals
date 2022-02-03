package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.androidpractical.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToUiWidgets: Button = findViewById(R.id.btn_Ui_Widgets)
        btnGoToUiWidgets.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(this, UiWidgetsActivity::class.java)
            startActivity(intent)
        }
    }
}