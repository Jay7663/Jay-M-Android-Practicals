package com.example.androidpractical.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R
import com.example.androidpractical.databinding.ActivityMetrialTextFiledsBinding
import com.shashank.sony.fancytoastlib.FancyToast

class MaterialTextFieldsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMetrialTextFiledsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMetrialTextFiledsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_items, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        FancyToast.makeText(this, item.title, FancyToast.LENGTH_SHORT, FancyToast.INFO, false)
            .show()
        return super.onOptionsItemSelected(item)
    }
}