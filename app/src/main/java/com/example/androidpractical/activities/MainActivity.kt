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
        setTitle(getString(R.string.activity_name_main_activity))
        setContentView(R.layout.activity_main)

        val btnGoToUiWidgets: Button = findViewById(R.id.btnUiWidgets)
        val btnLayouts: Button = findViewById(R.id.btnLayouts)
        val btnRecyclerViewAndAdapters: Button = findViewById(R.id.btnRecyclerViewAndAdapters)

        btnGoToUiWidgets.setOnClickListener {
            Toast.makeText(this, "Button Clicked", Toast.LENGTH_LONG).show()
            val intent = Intent(this, UiWidgetsActivity::class.java)
            startActivity(intent)
        }

        btnLayouts.setOnClickListener {
            val intent = Intent(this, AllLayoutsActivity::class.java)
            startActivity(intent)
        }

        btnRecyclerViewAndAdapters.setOnClickListener{
            val intent = Intent(this, RecyclerViewAndAdapters::class.java)
            startActivity(intent)
        }
    }
}