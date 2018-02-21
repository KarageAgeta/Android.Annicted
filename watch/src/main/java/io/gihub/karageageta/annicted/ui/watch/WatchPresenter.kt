package io.gihub.karageageta.annicted.ui.watch

import android.annotation.SuppressLint
import android.content.Context
import io.github.karageageta.network.ApiManager
import timber.log.Timber

class WatchPresenter(
        private val view: WatchContract.View,
        private val context: Context,
        private val apiManager: ApiManager
) : WatchContract.Presenter {
    @SuppressLint("CheckResult")
    override fun resume() {
        // TODO : Delete (Debug)
        apiManager.getMyWorks()
                .subscribe({
                    view.addWorks(it.works)
                }, {
                    Timber.d(it)
                })
    }
}
