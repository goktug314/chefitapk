package com.goktug314.chefit

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.app.Activity
import org.json.JSONArray

class MainActivity : Activity() {
    private lateinit var webView: WebView
    private val recipes by lazy { assets.open("recipes.json").bufferedReader().use { JSONArray(it.readText()).toString() } }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView)
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.allowFileAccess = true
        webView.settings.allowContentAccess = false
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = WebChromeClient()
        webView.addJavascriptInterface(RecipeBridge(), "AndroidData")
        if (savedInstanceState == null) webView.loadUrl("file:///android_asset/index.html") else webView.restoreState(savedInstanceState)
    }

    inner class RecipeBridge {
        @JavascriptInterface fun getRecipes(): String = recipes
    }

    override fun onSaveInstanceState(outState: Bundle) { webView.saveState(outState); super.onSaveInstanceState(outState) }
    @Deprecated("Deprecated in Android API")
    override fun onBackPressed() { if (webView.canGoBack()) webView.goBack() else super.onBackPressed() }
}
