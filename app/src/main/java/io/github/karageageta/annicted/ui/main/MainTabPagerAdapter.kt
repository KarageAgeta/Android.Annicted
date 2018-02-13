package io.github.karageageta.annicted.ui.main

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import io.github.karageageta.annicted.helper.MainTab
import io.github.karageageta.annicted.ui.home.HomeFragment

class MainTabPagerAdapter(
        fragmentManager: FragmentManager,
        context: Context
) : FragmentPagerAdapter(fragmentManager) {
    private val inflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Fragment? {
        val tab = MainTab.values()[position]
        return when (tab) {
            MainTab.HOME -> {
                HomeFragment.newInstance()
            }
            MainTab.SEARCH -> {
                HomeFragment.newInstance()
            }
            MainTab.MY_PAGE -> {
                HomeFragment.newInstance()
            }
        }
    }

    override fun getCount(): Int {
        return MainTab.values().size
    }
}