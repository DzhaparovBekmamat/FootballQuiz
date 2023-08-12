package com.template.footballquiz.webView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.template.footballquiz.R

class WebViewFragment : Fragment() {
    companion object {
        const val KEY_WEB_URL = "url"
        private const val DEFAULT_WEB_URL = "https://www.google.com"
    }

    private lateinit var webView: WebView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_webview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById(R.id.webView)
        val webUrl = arguments?.getString(KEY_WEB_URL) ?: DEFAULT_WEB_URL
        setupWebView(webUrl)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(webUrl: String) {
        val webSettings = webView.settings
        with(webSettings) {
            javaScriptEnabled = true
            domStorageEnabled = true
            javaScriptCanOpenWindowsAutomatically = true
            allowFileAccess = true
            allowContentAccess = true
            loadWithOverviewMode = true
            useWideViewPort = true
            setSupportZoom(false)
        }
        webView.webViewClient = WebViewClient()
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        webView.loadUrl(webUrl)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    @Suppress("DEPRECATION")
    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        }
    }
}
