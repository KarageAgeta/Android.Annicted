package io.github.karageageta.annicted.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.gihub.karageageta.annicted.ui.home.HomeContract
import io.gihub.karageageta.annicted.ui.home.HomePresenter
import javax.inject.Inject

@Module
class HomePresenterModule(private val view: HomeContract.View) {
    @Provides
    fun provideHomeContractPresenter(context: Context): HomeContract.Presenter {
        return HomePresenter(view, context)
    }
}
