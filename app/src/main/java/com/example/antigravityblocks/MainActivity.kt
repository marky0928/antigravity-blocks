package com.example.antigravityblocks

import android.annotation.SuppressLint
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : Activity() {

    private lateinit var web: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Full-screen, immersive, screen stays on while playing
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        window.statusBarColor = Color.TRANSPARENT
        window.navigationBarColor = Color.TRANSPARENT

        web = WebView(this).apply {
            setBackgroundColor(Color.parseColor("#0A0D16"))
            overScrollMode = WebView.OVER_SCROLL_NEVER
            isVerticalScrollBarEnabled = false
            isHorizontalScrollBarEnabled = false
            webViewClient = WebViewClient()
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true          // lets the game save your best score
                cacheMode = WebSettings.LOAD_NO_CACHE
                allowFileAccess = true
                setSupportZoom(false)
            }
            loadUrl("file:///android_asset/index.html")
        }
        setContentView(web)

        WindowInsetsControllerCompat(window, window.decorView).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.systemBars())
        }
    }

    override fun onResume() { super.onResume(); web.onResume() }
    override fun onPause() { web.onPause(); super.onPause() }

    override fun onDestroy() {
        web.destroy()
        super.onDestroy()
    }
}
