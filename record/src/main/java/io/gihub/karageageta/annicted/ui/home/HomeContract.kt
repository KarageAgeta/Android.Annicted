package io.gihub.karageageta.annicted.ui.home

import io.github.karageageta.annicted.BaseContract

interface HomeContract {
    interface View : BaseContract.View

    interface Presenter: BaseContract.Presenter {
        fun resume()
    }
}
