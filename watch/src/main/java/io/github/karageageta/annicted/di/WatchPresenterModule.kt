package io.github.karageageta.annicted.di

import android.content.Context
import io.github.karageageta.network.ApiManager
import dagger.Module
import dagger.Provides
import io.gihub.karageageta.annicted.ui.watch.WatchContract
import io.gihub.karageageta.annicted.ui.watch.WatchPresenter
import io.github.karageageta.database.RealmService

@Module
class WatchPresenterModule(private val view: WatchContract.View) {
    @Provides
    fun provideWatchContractPresenter(context: Context, apiManager: ApiManager, realmService: RealmService): WatchContract.Presenter {
        return WatchPresenter(view, context, apiManager, realmService)
    }
}
