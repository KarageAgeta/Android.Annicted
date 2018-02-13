package io.github.karageageta.annicted.di.component

import dagger.Component
import io.github.karageageta.annicted.di.module.ApplicationModule
import io.github.karageageta.annicted.di.module.HomePresenterModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    // main
    fun homeComponent(homePresenterModule: HomePresenterModule): HomeComponent
}