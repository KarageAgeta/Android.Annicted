package io.github.karageageta.annicted.di.module

import android.content.Context
import dagger.Module
import dagger.Provides
import io.github.karageageta.annicted.ui.mypage.MyPageContract
import io.github.karageageta.annicted.ui.mypage.MyPagePresenter

@Module
class MyPagePresenterModule(private val view: MyPageContract.View) {
    @Provides
    fun providesMyPagePresenter(
            context: Context
    ): MyPageContract.Presenter = MyPagePresenter(view, context)
}
