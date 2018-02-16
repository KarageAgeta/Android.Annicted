package io.github.karageageta.annicted.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import io.github.karageageta.annicted.AnnictedApplication
import io.github.karageageta.annicted.network.ApiService
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (ApiModule::class)])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: AnnictedApplication): Builder

        fun appModule(appModule: AppModule): Builder

        fun build(): AppComponent
    }

    fun getApplicationContext(): Context

    fun getApiService(): ApiService

    fun inject(application: AnnictedApplication)
}
