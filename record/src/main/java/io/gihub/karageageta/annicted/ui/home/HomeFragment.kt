package io.gihub.karageageta.annicted.ui.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.karageageta.annicted.AnnictedApplication
import io.github.karageageta.annicted.R
import io.github.karageageta.annicted.di.DaggerHomeComponent
import io.github.karageageta.annicted.di.HomePresenterModule
import javax.inject.Inject

class HomeFragment : Fragment(), HomeContract.View {
    companion object {
        fun newInstance() = HomeFragment()
    }

    @Inject lateinit var presenter: HomeContract.Presenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        DaggerHomeComponent.builder()
                .appComponent((activity?.application as AnnictedApplication).component)
                .homePresenterModule(HomePresenterModule(this))
                .build()
                .inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onResume() {
        super.onResume()
        presenter.resume()
    }
}
