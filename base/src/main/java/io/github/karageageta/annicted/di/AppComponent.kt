package io.github.karageageta.annicted.di

import android.content.Context
import io.github.karageageta.network.ApiService
import io.github.karageageta.network.di.ApiModule
import dagger.BindsInstance
import dagger.Component
import io.github.karageageta.annicted.AnnictedApplication
import io.github.karageageta.database.RealmService
import io.github.karageageta.database.di.DatabaseModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (ApiModule::class), (DatabaseModule::class)])
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

    fun getRealmService(): RealmService

    fun inject(application: AnnictedApplication)
}
