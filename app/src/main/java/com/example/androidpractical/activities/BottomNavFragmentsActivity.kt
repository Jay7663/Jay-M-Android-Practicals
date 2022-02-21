package com.example.androidpractical.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.androidpractical.R
import com.example.androidpractical.fragments.AddMessageFragment
import com.example.androidpractical.fragments.GalleryAddImageFragment
import com.example.androidpractical.fragments.ViewMessageFragment
import com.example.androidpractical.utils.MyViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavFragmentsActivity : AppCompatActivity() {

    private lateinit var bottomNavFragments: BottomNavigationView
    private lateinit var switchChange: SwitchCompat
    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_fragments)

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        bottomNavFragments = findViewById(R.id.bottomNavFragments)
        switchChange = findViewById(R.id.switchChange)
        val flagNormalOrJetpack: Boolean = intent.getBooleanExtra(getString(R.string.bottom_navigation_fragment_activity_state), false)
        switchChange.isChecked = flagNormalOrJetpack

        if (flagNormalOrJetpack) {
            loadJetpackNavigation()
        } else {
            loadNormalActivity()
        }

        switchChange.setOnCheckedChangeListener { _, state ->
            val intent = Intent(this, BottomNavFragmentsActivity::class.java)
            intent.putExtra(getString(R.string.bottom_navigation_fragment_activity_state), state)
            startActivity(intent)
            finish()
        }
    }

    private fun loadJetpackNavigation() {
        bottomNavFragments = findViewById(R.id.bottomNavFragments)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController: NavController = navHostFragment.navController
        NavigationUI.setupWithNavController(bottomNavFragments, navController)
        title = getString(R.string.activity_name_bottom_nav_fragments_jetpack)
    }

    private fun loadNormalActivity() {
        addFragment(GalleryAddImageFragment())
        bottomNavFragments.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_gallery -> {
                    addFragment(GalleryAddImageFragment())
                }
                R.id.nav_add_message -> {
                    addFragment(AddMessageFragment())
                }
                R.id.nav_view_message -> {
                    addFragment(ViewMessageFragment())
                }
            }
            true
        }
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.apply {
            replace(R.id.fragmentContainerView, fragment)
            commit()
        }
    }
}