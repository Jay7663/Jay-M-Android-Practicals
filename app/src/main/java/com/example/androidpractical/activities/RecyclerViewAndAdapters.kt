package com.example.androidpractical.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.androidpractical.R

class RecyclerViewAndAdapters : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_and_adapters)

        val btnListView: Button = findViewById(R.id.btnListView)
        val btnRecyclerView: Button = findViewById(R.id.btnRecyclerView)
        val btnBottomNavigationView: Button = findViewById(R.id.btnBottomNavigationView)
        val btnGridView: Button = findViewById(R.id.btnGridView)
        val btnTabLayoutViewPager: Button = findViewById(R.id.btnTabLayoutViewPager)

        btnListView.setOnClickListener {
            val intent = Intent(this, ListViewActivity::class.java)
            startActivity(intent)
        }

        btnRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnBottomNavigationView.setOnClickListener {
            val intent = Intent(this, BottomNavigationViewActivity::class.java)
            startActivity(intent)
        }

        btnGridView.setOnClickListener {
            val intent = Intent(this, GridWithRecyclerViewActivity::class.java)
            startActivity(intent)
        }

        btnTabLayoutViewPager.setOnClickListener {
            val intent = Intent(this, ViewPagerWithTabActivity::class.java)
            startActivity(intent)
        }
    }
}