package io.gihub.karageageta.annicted.ui.login

import android.annotation.SuppressLint
import android.content.Context
import io.github.karageageta.network.ApiManager
import io.github.karageageta.network.BuildConfig
import timber.log.Timber
import java.util.regex.Pattern

class LoginPresenter(
    private val view: LoginContract.View,
    private val context: Context,
    private val apiManager: ApiManager
) : LoginContract.Presenter {
    companion object {
        private const val AUTHORIZE_URL = "https://jp.annict.com/oauth/authorize?client_id=${BuildConfig.ANNICT_CLIENT_ID}&redirect_uri=urn%3Aietf%3Awg%3Aoauth%3A2.0%3Aoob&response_type=code&scope=read+write"
        private const val AUTHORIZE_CODE_URL = """https:\/\/jp\.annict\.com\/oauth\/authorize\/native\?code=(.+)"""
    }

    @SuppressLint("CheckResult")
    override fun login() {
        view.openUrl(AUTHORIZE_URL)
    }

    override fun isApproved(url: String): Boolean =
        AUTHORIZE_CODE_URL.toRegex().run {
            matches(url)
        }

    override fun extractAccessToken(url: String) {
        Timber.d(extractCode(url))
        view.showMain()
        view.finish()
    }

    // private
    private fun extractCode(url: String): String {
        return Pattern.compile(AUTHORIZE_CODE_URL).run {
            matcher(url)
        }.run {
                if (this.find()) this.group(1) else ""
            }
    }
}
