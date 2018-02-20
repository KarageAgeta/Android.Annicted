package io.github.karageageta.annicted.di

import dagger.Component
import io.gihub.karageageta.annicted.ui.watch.WatchFragment

@PerFragment
@FragmentScoped
@Component(dependencies = [(AppComponent::class)],
        modules = [(WatchPresenterModule::class)])
interface WatchComponent {
    fun inject(fragment: WatchFragment)
}
