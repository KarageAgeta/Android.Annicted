package io.gihub.karageageta.annicted.ui.watch

import io.github.karageageta.annicted.BaseContract
import io.github.karageageta.annicted.model.Work

interface WatchContract {
    interface View : BaseContract.View {
        fun addWorks(work: List<Work>)
    }

    interface Presenter: BaseContract.Presenter {
        fun resume()
    }
}
