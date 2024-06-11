package com.uti.agrimateee.Activity

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.uti.agrimateee.R

class WebViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web_view)

        val title = intent.getStringExtra("title") ?: "Untitled"
        val url = intent.getStringExtra("url") ?: ""

        supportActionBar?.title = title

        val webView: WebView = findViewById(R.id.webView)

        // Set WebViewClient to handle page navigation and rendering
        webView.webViewClient = WebViewClient()

        webView.settings.javaScriptEnabled = true
        webView.loadUrl(url)


    }
}