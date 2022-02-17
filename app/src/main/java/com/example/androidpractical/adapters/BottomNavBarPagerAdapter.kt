package com.example.androidpractical.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.androidpractical.fragments.FavoriteFragment
import com.example.androidpractical.fragments.HomeFragment
import com.example.androidpractical.fragments.SearchFragment
import com.example.androidpractical.utils.Constants.ONE
import com.example.androidpractical.utils.Constants.THREE
import com.example.androidpractical.utils.Constants.TWO

class BottomNavBarPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun createFragment(position: Int): Fragment {
        when (position) {
            ONE -> return FavoriteFragment()
            TWO -> return SearchFragment()
        }
        return HomeFragment()
    }

    override fun getItemCount(): Int {
        return THREE
    }
}