package io.gihub.karageageta.annicted.di

import dagger.Component
import io.gihub.karageageta.annicted.ui.login.LoginFragment
import io.github.karageageta.annicted.di.AppComponent
import io.github.karageageta.annicted.di.FragmentScoped
import io.github.karageageta.annicted.di.PerFragment

@PerFragment
@FragmentScoped
@Component(dependencies = [(AppComponent::class)],
        modules = [(LoginPresenterModule::class)])
interface LoginComponent {
    fun inject(fragment: LoginFragment)
}
