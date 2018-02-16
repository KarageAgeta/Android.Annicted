package io.gihub.karageageta.annicted.ui.home

import android.content.Context
import timber.log.Timber

class HomePresenter(
        private val view: HomeContract.View,
        private val context: Context
) : HomeContract.Presenter {
    override fun resume() {
        // TODO : Delete (Debug)
        Timber.d(context.toString())
    }
}
