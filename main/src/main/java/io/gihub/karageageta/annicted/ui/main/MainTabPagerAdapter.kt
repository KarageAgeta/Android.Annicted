package io.gihub.karageageta.annicted.ui.main

import android.content.Context
import android.graphics.Color
import android.graphics.PorterDuff
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import io.github.karageageta.annicted.R
import io.gihub.karageageta.annicted.helper.MainTab
import io.gihub.karageageta.annicted.ui.watch.WatchFragment

class MainTabPagerAdapter(
        fragmentManager: FragmentManager,
        private val context: Context
) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment? {
        val tab = MainTab.values()[position]
        return when (tab) {
            MainTab.HOME -> {
                // WatchFragment.newInstance()
                WatchFragment.newInstance()
            }
            MainTab.SEARCH -> {
                // WatchFragment.newInstance()
                WatchFragment.newInstance()
            }
            MainTab.MY_PAGE -> {
                WatchFragment.newInstance()
            }
        }
    }

    override fun getCount(): Int {
        return MainTab.values().size
    }

    fun setupTabView(tabLayout: TabLayout) {
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val tabIconColor = if (i == 0) ContextCompat.getColor(context, R.color.colorAccent) else Color.BLACK
            tab?.icon = ContextCompat.getDrawable(context, MainTab.values()[i].srcInt)
            tab?.icon?.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
        }
    }
}