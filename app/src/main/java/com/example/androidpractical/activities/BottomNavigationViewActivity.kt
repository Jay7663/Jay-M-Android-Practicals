package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.example.androidpractical.R
import com.example.androidpractical.adapters.BottomNavBarPagerAdapter
import com.example.androidpractical.utils.Constants.ONE
import com.example.androidpractical.utils.Constants.TWO
import com.example.androidpractical.utils.Constants.ZERO
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayoutMediator

class BottomNavigationViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation_view)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val viewPager: ViewPager2 = findViewById(R.id.vpFragmentContainer)

        val adapter = BottomNavBarPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> viewPager.setCurrentItem(ZERO, true)
                R.id.nav_favorite -> viewPager.setCurrentItem(ONE, true)
                R.id.nav_search -> viewPager.setCurrentItem(TWO, true)
            }
            true
        }
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    ZERO -> bottomNavigationView.selectedItemId = R.id.nav_home
                    ONE -> bottomNavigationView.selectedItemId = R.id.nav_favorite
                    TWO -> bottomNavigationView.selectedItemId = R.id.nav_search
                }
                super.onPageSelected(position)
            }
        })
    }
}