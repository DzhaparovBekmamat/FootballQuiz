package com.template.footballquiz.splachScreen

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.template.footballquiz.R
import com.template.footballquiz.webView.WebViewFragment
import com.template.footballquiz.fragments.GameFragment

@Suppress("DEPRECATION")
class SplashFragment : Fragment() {
    private val delayMillis: Long = 2000

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({
            if (shouldShowWebView()) {
                val webFragment = WebViewFragment()
                val bundle = Bundle()
                bundle.putString(WebViewFragment.KEY_WEB_URL, getLocalLink())
                webFragment.arguments = bundle
                parentFragmentManager.beginTransaction()
                    .replace(R.id.webView, webFragment)
                    .commit()
            } else {
                val gameFragment = GameFragment()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.gameFragment, gameFragment)
                    .commit()
            }
        }, delayMillis)
    }

    private fun shouldShowWebView(): Boolean {
        val localLink = getLocalLink()
        val isEmulator = isEmulator()
        return localLink.isNotEmpty() && !isEmulator
    }

    private fun getLocalLink(): String {
        return "https://www.example.com"
    }

    private fun isEmulator(): Boolean {
        return Build.FINGERPRINT.contains("generic")
    }
}
