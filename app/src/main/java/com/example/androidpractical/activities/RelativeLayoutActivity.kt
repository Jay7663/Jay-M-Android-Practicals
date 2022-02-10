package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import com.example.androidpractical.R

class RelativeLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)

        val spinnerOptions = arrayOf(
            getString(R.string.spinner_item_ratting_very_bad),
            getString(R.string.spinner_item_ratting_bad),
            getString(R.string.spinner_item_ratting_average),
            getString(R.string.spinner_item_ratting_good),
            getString(R.string.spinner_item_ratting_very_good)
        )

        val spFeedback: Spinner = findViewById(R.id.spFeedback)
        val btnSendFeedback: Button = findViewById(R.id.btnSendFeedback)

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spFeedback.adapter = arrayAdapter

        btnSendFeedback.setOnClickListener {
            Toast.makeText(this, "Feedback Submitted !!!", Toast.LENGTH_LONG).show()
        }
    }
}