package io.gihub.karageageta.annicted.di

import android.content.Context
import io.github.karageageta.network.ApiManager
import dagger.Module
import dagger.Provides
import io.gihub.karageageta.annicted.ui.login.LoginContract
import io.gihub.karageageta.annicted.ui.login.LoginPresenter

@Module
class LoginPresenterModule(private val view: LoginContract.View) {
    @Provides
    fun provideLoginPresenter(context: Context, apiManager: ApiManager): LoginContract.Presenter {
        return LoginPresenter(view, context, apiManager)
    }
}
