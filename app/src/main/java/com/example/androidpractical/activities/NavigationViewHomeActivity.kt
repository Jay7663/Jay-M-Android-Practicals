package com.example.androidpractical.activities

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.example.androidpractical.R
import com.example.androidpractical.databinding.ActivityNavigationViewHomeBinding
import com.shashank.sony.fancytoastlib.FancyToast

class NavigationViewHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNavigationViewHomeBinding
    private lateinit var actionBarToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNavigationViewHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialData()
    }

    private fun initialData() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        actionBarToggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.nav_open, R.string.nav_close)
        actionBarToggle.syncState()
        binding.drawerLayout.addDrawerListener(actionBarToggle)

        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_camera -> {
                    FancyToast.makeText(
                        this,
                        getString(R.string.nav_item_camera),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    )
                        .show()
                }
                R.id.nav_gallery -> {
                    FancyToast.makeText(
                        this,
                        getString(R.string.nav_item_gallery),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    )
                        .show()
                }
                R.id.nav_slideshow -> {
                    FancyToast.makeText(
                        this,
                        getString(R.string.nav_item_slideshow),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    )
                        .show()
                }
                R.id.nav_manage -> {
                    FancyToast.makeText(
                        this,
                        getString(R.string.nav_item_tools),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    )
                        .show()
                }
                R.id.nav_share -> {
                    FancyToast.makeText(
                        this,
                        getString(R.string.nav_item_share),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    )
                        .show()
                }
                R.id.nav_send -> {
                    FancyToast.makeText(
                        this,
                        getString(R.string.nav_item_send),
                        FancyToast.LENGTH_SHORT,
                        FancyToast.INFO,
                        false
                    )
                        .show()
                }
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        binding.drawerLayout.openDrawer(binding.navigationView)
        return true
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}