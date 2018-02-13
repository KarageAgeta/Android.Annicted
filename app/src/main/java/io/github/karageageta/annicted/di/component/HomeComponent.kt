package io.github.karageageta.annicted.di.component

import dagger.Subcomponent
import io.github.karageageta.annicted.di.module.HomePresenterModule
import io.github.karageageta.annicted.ui.home.HomeFragment

@Subcomponent(modules = [(HomePresenterModule::class)])
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}