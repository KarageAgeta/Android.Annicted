package io.github.karageageta.annicted

import android.app.Application
import io.github.karageageta.annicted.di.AppComponent
import io.github.karageageta.annicted.di.AppModule
import io.github.karageageta.annicted.di.DaggerAppComponent
import timber.log.Timber

class AnnictedApplication : Application() {
    lateinit var component: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()

        component = DaggerAppComponent.builder()
                .application(this)
                .appModule(AppModule(this))
                .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            // fix
            Timber.plant(Timber.DebugTree())
        }
    }
}
