package io.github.karageageta.annicted.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.gihub.karageageta.annicted.ui.home.HomeContract
import io.gihub.karageageta.annicted.ui.home.HomePresenter
import io.github.karageageta.annicted.network.ApiManager

@Module
class HomePresenterModule(private val view: HomeContract.View) {
    @Provides
    fun provideHomeContractPresenter(context: Context, apiManager: ApiManager): HomeContract.Presenter {
        return HomePresenter(view, context, apiManager)
    }
}
