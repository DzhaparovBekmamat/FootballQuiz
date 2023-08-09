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
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.template.footballquiz.R

@Suppress("DEPRECATION")
class WebViewFragment : Fragment() {
    companion object {
        private const val KEY_WEB_URL = "url"
        private const val DEFAULT_WEB_URL = "https://www.google.com"
    }
    private lateinit var webView: WebView
    private lateinit var firebaseRemoteConfig: FirebaseRemoteConfig
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_webview, container, false)
        webView = view.findViewById(R.id.webView)
        return view
    }
    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings =
            FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(3600).build()
        firebaseRemoteConfig.setConfigSettingsAsync(configSettings)
        firebaseRemoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val webUrl = firebaseRemoteConfig.getString(KEY_WEB_URL)
                setupWebView(webUrl)
            } else {
                setupWebView(DEFAULT_WEB_URL)
            }
        }
    }
    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView(webUrl: String?) {
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.allowFileAccess = true
        webSettings.allowContentAccess = true
        webSettings.loadWithOverviewMode = true
        webSettings.useWideViewPort = true
        webSettings.setSupportZoom(false)
        webView.webViewClient = WebViewClient()
        val cookieManager = CookieManager.getInstance()
        cookieManager.setAcceptCookie(true)
        if (webUrl != null) {
            webView.loadUrl(webUrl)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        webView.saveState(outState)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (savedInstanceState != null) {
            webView.restoreState(savedInstanceState)
        }
    }
}
