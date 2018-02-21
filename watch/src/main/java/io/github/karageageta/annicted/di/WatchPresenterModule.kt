package io.github.karageageta.annicted.di

import android.content.Context
import io.github.karageageta.network.ApiManager
import dagger.Module
import dagger.Provides
import io.gihub.karageageta.annicted.ui.watch.WatchContract
import io.gihub.karageageta.annicted.ui.watch.WatchPresenter

@Module
class WatchPresenterModule(private val view: WatchContract.View) {
    @Provides
    fun provideWatchContractPresenter(context: Context, apiManager: ApiManager): WatchContract.Presenter {
        return WatchPresenter(view, context, apiManager)
    }
}
