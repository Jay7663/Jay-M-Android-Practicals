package com.example.androidpractical.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageFromUrl")
fun ImageView.loadImageFromUrl(imageUrl: String) {
    Glide.with(this).load(imageUrl).into(this)
}

@InverseBindingAdapter(attribute = "android:text")
fun captureTextValue(view: TextView): String {
    return view.text.toString().uppercase()
}