package com.example.androidpractical.utils

import android.app.Activity
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import com.example.androidpractical.R

fun Toast.showCustomToast(message: String, activity: Activity) {
    val layout = activity.layoutInflater.inflate(
        R.layout.custom_toast_layout,
        activity.findViewById(R.id.rlCustomToast)
    )

    val textView = layout.findViewById<TextView>(R.id.tvText)
    textView.text = message

    this.apply {
        setGravity(Gravity.BOTTOM, 0, 40)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}