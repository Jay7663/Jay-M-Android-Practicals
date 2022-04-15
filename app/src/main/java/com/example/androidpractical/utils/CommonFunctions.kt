package com.example.androidpractical.utils

import com.example.androidpractical.utils.Constants.PASSWORD_PATTERN
import java.util.regex.Matcher
import java.util.regex.Pattern

object CommonFunctions {
    fun isValidPassword(password: String): Boolean {
        val pattern = Pattern.compile(PASSWORD_PATTERN)
        val matcher: Matcher = pattern.matcher(password)
        return matcher.matches()
    }
}