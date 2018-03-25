package io.gihub.karageageta.annicted.helper

import android.annotation.SuppressLint
import android.content.Context
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

@SuppressLint("SetJavaScriptEnabled")
class AuthorizeWebView(context: Context) : WebView(context) {
    interface AfterLoadListener {
        fun onLoaded(url: String): Boolean
    }

    private var afterLoadListener: AfterLoadListener? = null

    init {
        isVerticalScrollBarEnabled = false
        isHorizontalScrollBarEnabled = false
        settings.javaScriptEnabled = true
        settings.javaScriptCanOpenWindowsAutomatically = true
        settings.setSupportMultipleWindows(true)
        settings.cacheMode = WebSettings.LOAD_NO_CACHE
        webChromeClient = WebChromeClient()
        webViewClient = createWebViewClient()
    }

    fun setAfterLoadListener(listener: AfterLoadListener) {
        afterLoadListener = listener
    }

    private fun createWebViewClient(): AuthorizeWebViewClient = AuthorizeWebViewClient()

    private inner class AuthorizeWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean =
            url.let { afterLoadListener?.onLoaded(it) }
                ?: super.shouldOverrideUrlLoading(view, url)
    }
}
