package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R

class OtherImportantViewsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other_important_views)

        val btnWebView: Button = findViewById(R.id.btnWebView)
        val btnScrollView: Button = findViewById(R.id.btnScrollView)
        val btnSearchView: Button = findViewById(R.id.btnSearchView)

        btnWebView.setOnClickListener {
            val intent = Intent(this, AdvancedWebViewActivity::class.java)
            startActivity(intent)
        }

        btnScrollView.setOnClickListener {
            val intent = Intent(this, ScrollViewActivity::class.java)
            startActivity(intent)
        }

        btnSearchView.setOnClickListener {
            val intent = Intent(this, SearchViewActivity::class.java)
            startActivity(intent)
        }
    }
}