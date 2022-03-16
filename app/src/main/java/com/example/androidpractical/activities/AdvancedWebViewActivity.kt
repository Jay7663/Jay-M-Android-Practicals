package com.example.androidpractical.activities

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpractical.R

class AdvancedWebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced_web_view)

        val etUrl: EditText = findViewById(R.id.etUrl)
        val btnLoadUrl: Button = findViewById(R.id.btnLoadSite)
        val webView: WebView = findViewById(R.id.webView)
        var url = getString(R.string.web_view_pdf_loader_google_link) + getString(R.string.web_view_pdf_link)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)

        btnLoadUrl.setOnClickListener {
            url = etUrl.text.toString()
            webView.loadUrl(url)
        }

    }
}