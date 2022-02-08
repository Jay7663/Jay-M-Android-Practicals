package com.example.androidpractical.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import com.example.androidpractical.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val etUrl: EditText = findViewById(R.id.etUrl)
        val btnLoadUrl: Button = findViewById(R.id.btnLoadSite)
        val webView: WebView = findViewById(R.id.webView)

        var url = "https://www.google.com/"

        webView.webViewClient = WebViewClient()

        webView.loadUrl(url)

        btnLoadUrl.setOnClickListener {
            url = etUrl.text.toString()
            webView.loadUrl(url)
        }
    }
}