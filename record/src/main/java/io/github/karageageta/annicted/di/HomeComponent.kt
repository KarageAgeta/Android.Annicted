package io.github.karageageta.annicted.di

import dagger.Component
import io.gihub.karageageta.annicted.ui.home.HomeFragment

@PerFragment
@FragmentScoped
@Component(dependencies = [(AppComponent::class)],
        modules = [(HomePresenterModule::class)])
interface HomeComponent {
    fun inject(fragment: HomeFragment)
}
