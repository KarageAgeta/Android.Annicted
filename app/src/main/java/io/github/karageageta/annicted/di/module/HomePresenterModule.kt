package io.github.karageageta.annicted.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.karageageta.annicted.ui.home.HomeContract
import io.github.karageageta.annicted.ui.home.HomePresenter

@Module
class HomePresenterModule(private val view: HomeContract.View) {
    @Provides
    fun providesHomePresenter(
            context: Context
    ): HomeContract.Presenter = HomePresenter(view, context)
}
