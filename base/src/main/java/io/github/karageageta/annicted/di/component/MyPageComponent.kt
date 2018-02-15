package io.github.karageageta.annicted.di.component

import dagger.Subcomponent
import io.github.karageageta.annicted.di.module.MyPagePresenterModule
import io.github.karageageta.annicted.ui.mypage.MyPageFragment

@Subcomponent(modules = [(MyPagePresenterModule::class)])
interface MyPageComponent {
    fun inject(fragment: MyPageFragment)
}
