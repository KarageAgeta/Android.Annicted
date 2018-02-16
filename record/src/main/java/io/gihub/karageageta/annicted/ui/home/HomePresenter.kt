package io.gihub.karageageta.annicted.ui.home

import android.content.Context
import io.github.karageageta.annicted.network.ApiManager
import timber.log.Timber

class HomePresenter(
        private val view: HomeContract.View,
        private val context: Context,
        private val apiManager: ApiManager
) : HomeContract.Presenter {
    override fun resume() {
        // TODO : Delete (Debug)
        Timber.d(context.toString())
    }
}
