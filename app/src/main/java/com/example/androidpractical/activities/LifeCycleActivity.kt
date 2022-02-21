package com.example.androidpractical.activities

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.androidpractical.R
import com.example.androidpractical.fragments.FavoriteFragment
import com.example.androidpractical.fragments.HomeFragment
import com.example.androidpractical.utils.Constants.ACTIVITY_TAG

class LifeCycleActivity : AppCompatActivity() {
    var flagFragment: Boolean = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        Log.d(ACTIVITY_TAG, "onCreate")

        val btnLoadFragment: Button = findViewById(R.id.btnLoadFragment)

        btnLoadFragment.setOnClickListener {
            if (flagFragment) {
                flagFragment = false
                loadFragment(HomeFragment())
                btnLoadFragment.text = getString(R.string.lifecycle_activity_button_favorite_text)
            } else {
                flagFragment = true
                loadFragment(FavoriteFragment())
                btnLoadFragment.text = getString(R.string.lifecycle_activity_button_home_text)
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.flFragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(ACTIVITY_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ACTIVITY_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ACTIVITY_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ACTIVITY_TAG, "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(ACTIVITY_TAG, "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ACTIVITY_TAG, "onDestroy")
    }
}