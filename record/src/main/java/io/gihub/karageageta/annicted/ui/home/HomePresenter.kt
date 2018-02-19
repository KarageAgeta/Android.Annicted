package io.gihub.karageageta.annicted.ui.home

import android.annotation.SuppressLint
import android.content.Context
import io.github.karageageta.annicted.network.ApiManager
import timber.log.Timber

class HomePresenter(
        private val view: HomeContract.View,
        private val context: Context,
        private val apiManager: ApiManager
) : HomeContract.Presenter {
    @SuppressLint("CheckResult")
    override fun resume() {
        // TODO : Delete (Debug)
        apiManager.getMyWorks()
                .subscribe({
                    it.works.forEach { Timber.d(it.toString()) }
                }, {
                    Timber.d(it)
                })
    }
}
