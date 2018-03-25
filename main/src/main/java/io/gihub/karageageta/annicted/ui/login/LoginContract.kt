package io.gihub.karageageta.annicted.ui.login

import io.github.karageageta.annicted.BaseContract

interface LoginContract {
    interface View : BaseContract.View {
        fun openUrl(url: String)
        fun showMain()
        fun finish()
    }

    interface Presenter : BaseContract.Presenter {
        fun login()
        fun isApproved(url: String): Boolean
        fun extractAccessToken(url: String)
    }
}
