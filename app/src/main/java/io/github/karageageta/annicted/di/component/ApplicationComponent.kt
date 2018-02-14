package io.github.karageageta.annicted.di.component

import dagger.Component
import io.github.karageageta.annicted.di.module.ApplicationModule
import io.github.karageageta.annicted.di.module.HomePresenterModule
import io.github.karageageta.annicted.di.module.MyPagePresenterModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(ApplicationModule::class)])
interface ApplicationComponent {
    // home
    fun homeComponent(homePresenterModule: HomePresenterModule): HomeComponent
    // mypage
    fun mypageComponent(myPagePresenterModule: MyPagePresenterModule): MyPageComponent
}
