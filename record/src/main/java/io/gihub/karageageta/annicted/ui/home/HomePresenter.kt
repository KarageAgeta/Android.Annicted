package io.gihub.karageageta.annicted.ui.home

import android.content.Context
import io.github.karageageta.annicted.anime.network.ApiManager

class HomePresenter(
        private val view: HomeContract.View,
        private val context: Context,
        private val apiManager: ApiManager
) : HomeContract.Presenter
