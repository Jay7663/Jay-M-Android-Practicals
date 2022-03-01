package com.example.androidpractical.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R

class ActivityIntentFragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_fragment)

        val btnLifeCycle: Button = findViewById(R.id.btnLifeCycle)
        val btnIntent: Button = findViewById(R.id.btnIntent)
        val btnBottomNavFragments: Button = findViewById(R.id.btnBottomNavFragments)

        btnLifeCycle.setOnClickListener {
            val intent = Intent(this, LifeCycleActivity::class.java)
            startActivity(intent)
        }

        btnIntent.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(getString(R.string.intent_telephone_number))
            startActivity(intent)
        }

        btnBottomNavFragments.setOnClickListener {
            val intent = Intent(this, BottomNavFragmentsActivity::class.java)
            startActivity(intent)
        }
    }
}