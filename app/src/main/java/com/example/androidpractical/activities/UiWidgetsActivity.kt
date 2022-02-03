package com.example.androidpractical.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.example.androidpractical.R
import com.example.androidpractical.utils.showCustomToast

class UiWidgetsActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ui_widgets)

        val btnSimple: Button = findViewById(R.id.btnSimple)
        val imageButton: ImageButton = findViewById(R.id.btnImage)
        val btnShowCustomToast: Button = findViewById(R.id.btnCustomToast)
        val btnGoToForm: Button = findViewById(R.id.btnGoToForm)
        val btnToggle: ToggleButton = findViewById(R.id.toggleButton)
        val layout: LinearLayout = findViewById(R.id.linearLayout)

        btnSimple.setOnClickListener {
            Toast.makeText(this, "Simple Button Clicked", Toast.LENGTH_LONG).show()
        }

        imageButton.setOnClickListener {
            Toast.makeText(this, "Image Button Clicked", Toast.LENGTH_LONG).show()
        }

        btnShowCustomToast.setOnClickListener {
            Toast(this).showCustomToast("Hello! This is a custom Toast!", this)
        }

        btnGoToForm.setOnClickListener {
            val intent = Intent(this, UiWidgetsFormActivity::class.java)
            startActivity(intent)
        }

        btnToggle.setOnClickListener {
            if (btnToggle.isChecked()) {
                btnToggle.setText(getString(R.string.toggle_button_background_white))
                layout.setBackgroundColor(ContextCompat.getColor(this, R.color.light_background))
                btnToggle.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            } else {
                btnToggle.setText(getString(R.string.toggle_button_background_green))
                layout.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                btnToggle.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_700))
            }
        }
    }
}