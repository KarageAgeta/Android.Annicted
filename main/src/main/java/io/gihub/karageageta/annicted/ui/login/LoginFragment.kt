package io.gihub.karageageta.annicted.ui.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import io.gihub.karageageta.annicted.R
import io.gihub.karageageta.annicted.di.DaggerLoginComponent
import io.gihub.karageageta.annicted.di.LoginPresenterModule
import io.gihub.karageageta.annicted.helper.AuthorizeWebView
import io.gihub.karageageta.annicted.ui.main.MainActivity
import io.github.karageageta.annicted.AnnictedApplication
import kotlinx.android.synthetic.main.fragment_login.*
import timber.log.Timber
import java.util.regex.Pattern
import javax.inject.Inject

class LoginFragment : Fragment(),
    LoginContract.View,
    AuthorizeWebView.AfterLoadListener {
    companion object {
        fun newInstance() = LoginFragment()
    }

    @Inject lateinit var presenter: LoginContract.Presenter
    private lateinit var webView: AuthorizeWebView

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerLoginComponent.builder()
            .appComponent((activity?.application as AnnictedApplication).component)
            .loginPresenterModule(LoginPresenterModule(this))
            .build()
            .inject(this)
        webView = AuthorizeWebView(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_login, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login.addView(webView)
        webView.setAfterLoadListener(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.login()
    }

    // LoginContract.View
    override fun openUrl(url: String) {
        webView.loadUrl(url)
    }

    override fun showMain() {
        Intent(activity, MainActivity::class.java).let {
            startActivity(it)
        }
    }

    override fun finish() {
        activity?.finish()
    }

    // AuthorizeWebView.AfterLoadListener
    override fun onLoaded(url: String): Boolean {
        Timber.d(url)
        Timber.d(presenter.isApproved(url).toString())
        if (!presenter.isApproved(url)) return false

        presenter.extractAccessToken(url)
        return true
    }
}
