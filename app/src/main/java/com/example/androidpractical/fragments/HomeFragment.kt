package com.example.androidpractical.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidpractical.R
import com.example.androidpractical.utils.Constants.FRAGMENT_TAG

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(FRAGMENT_TAG, "onCreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(FRAGMENT_TAG, "onViewCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Log.d(FRAGMENT_TAG, "onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        Log.d(FRAGMENT_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(FRAGMENT_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(FRAGMENT_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(FRAGMENT_TAG, "onStop")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(FRAGMENT_TAG, "onSaveInstanceState")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(FRAGMENT_TAG, "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(FRAGMENT_TAG, "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(FRAGMENT_TAG, "onDetach")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(FRAGMENT_TAG, "onAttach")
    }
}