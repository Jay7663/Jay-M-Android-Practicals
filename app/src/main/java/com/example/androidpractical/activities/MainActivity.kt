package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle(getString(R.string.activity_name_main_activity))
        setContentView(R.layout.activity_main)

        val btnGoToUiWidgets: Button = findViewById(R.id.btnUiWidgets)
        val btnLayouts: Button = findViewById(R.id.btnLayouts)
        val btnRecyclerViewAndAdapters: Button = findViewById(R.id.btnRecyclerViewAndAdapters)
        val btnActivityIntentFragment: Button = findViewById(R.id.btnActivityIntentFragment)
        val btnOtherImportantViews: Button = findViewById(R.id.btnOtherImportantViews)
        val btnWebServices: Button = findViewById(R.id.btnWebServices)
        val btnArchitecture: Button = findViewById(R.id.btnArchitecture)

        btnGoToUiWidgets.setOnClickListener {
            val intent = Intent(this, UiWidgetsActivity::class.java)
            startActivity(intent)
        }

        btnLayouts.setOnClickListener {
            val intent = Intent(this, AllLayoutsActivity::class.java)
            startActivity(intent)
        }

        btnRecyclerViewAndAdapters.setOnClickListener {
            val intent = Intent(this, RecyclerViewAndAdapters::class.java)
            startActivity(intent)
        }

        btnActivityIntentFragment.setOnClickListener {
            val intent = Intent(this, ActivityIntentFragmentActivity::class.java)
            startActivity(intent)
        }

        btnOtherImportantViews.setOnClickListener {
            val intent = Intent(this, OtherImportantViewsActivity::class.java)
            startActivity(intent)
        }

        btnWebServices.setOnClickListener {
            val intent = Intent(this, WsLogInActivity::class.java)
            startActivity(intent)
        }

        btnArchitecture.setOnClickListener {
            val intent = Intent(this, ArchitectureHomeActivity::class.java)
            startActivity(intent)
        }
    }
}