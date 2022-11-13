package com.example.ui_example.web

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.webkit.*
import androidx.appcompat.app.AppCompatActivity
import com.example.ui_example.R
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web)

        val url = intent.getStringExtra("Web_Url")

        setupWebView()

        if (!url.isNullOrEmpty()) {
            webView.loadUrl(url)
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        val settings = webView.settings
        settings.javaScriptEnabled = true
        settings.builtInZoomControls = true
        settings.displayZoomControls = true
        settings.useWideViewPort = true
        settings.domStorageEnabled = true
        settings.loadWithOverviewMode = true
        settings.setSupportZoom(true)

        webView.webViewClient = object :WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }

            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)

            }

            override fun onReceivedSslError(
                view: WebView?,
                handler: SslErrorHandler?,
                error: SslError?
            ) {
                super.onReceivedSslError(view, handler, error)

                handler?.cancel()
            }
        }

        webView.webChromeClient = object :WebChromeClient() {
            override fun onJsAlert(
                view: WebView?,
                url: String?,
                message: String?,
                result: JsResult?
            ): Boolean {
                if (!message.isNullOrEmpty()) {
                    Log.d("jsAlertMessage", message)
                }
                return true
            }
        }
    }
}