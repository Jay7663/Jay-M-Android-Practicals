package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.androidpractical.R

class LinearLayoutActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)

        val spinnerOptions = arrayOf(
            getString(R.string.spinner_item_ratting_very_bad),
            getString(R.string.spinner_item_ratting_bad),
            getString(R.string.spinner_item_ratting_average),
            getString(R.string.spinner_item_ratting_good),
            getString(R.string.spinner_item_ratting_very_good)
        )

        val spFeedback: Spinner = findViewById(R.id.spFeedback)
        val btnSendFeedback: Button = findViewById(R.id.btnSendFeedback)

        spFeedback.onItemSelectedListener = this

        val arrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerOptions)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spFeedback.adapter = arrayAdapter

        btnSendFeedback.setOnClickListener {
            Toast.makeText(this, "Feedback Submitted !!!", Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, id: Long) {
        Toast.makeText(this, "Item Selected $position", Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
    }
}