package io.github.karageageta.annicted.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return application
    }
}