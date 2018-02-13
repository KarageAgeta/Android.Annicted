package io.github.karageageta.annicted.ui.home

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.karageageta.annicted.AnnictedApplication

import io.github.karageageta.annicted.R
import io.github.karageageta.annicted.di.module.HomePresenterModule

class HomeFragment : Fragment(), HomeContract.View {
    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity?.application as AnnictedApplication).component
                .homeComponent(HomePresenterModule(this))
                .inject(this)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)
}
