package com.example.androidpractical.activities

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R
import com.example.androidpractical.databinding.ActivityCoordinatorScrollBinding
import com.google.android.material.snackbar.Snackbar


class CoordinatorScrollActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCoordinatorScrollBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinatorScrollBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fabSnackBar.setOnClickListener {
            val snackBar = Snackbar.make(it, getString(R.string.snackbar_one_item_added), Snackbar.LENGTH_LONG)
                .setAction(getString(R.string.snackbar_undo)) {
                    Toast.makeText(
                        this,
                        getString(R.string.action_works),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            snackBar.apply {
                this.setActionTextColor(Color.RED)
                this.setTextColor(Color.YELLOW)
                this.setBackgroundTint(Color.DKGRAY)
                this.show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_items, menu);
        return super.onCreateOptionsMenu(menu)
    }
}