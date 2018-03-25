package io.gihub.karageageta.annicted.ui.main

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.graphics.PorterDuff
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import io.gihub.karageageta.annicted.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),
        TabLayout.OnTabSelectedListener {
    private val select = NavigationView.OnNavigationItemSelectedListener {
        drawer.closeDrawers()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        setSupportActionBar(toolbar)

        view_pager.also { viewPager ->
            MainTabPagerAdapter(supportFragmentManager, this).also {
                viewPager.adapter = it
                tab.setupWithViewPager(viewPager)
                it.setupTabView(tab)
                tab.addOnTabSelectedListener(this)
            }
        }

        ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name).also {
            drawer.addDrawerListener(it)
            it.syncState()
        }
        drawer_navigation.setNavigationItemSelectedListener(select)
    }


    override fun onTabReselected(tab: TabLayout.Tab?) {
    }

    override fun onTabUnselected(tab: TabLayout.Tab?) {
        tab?.icon?.setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN)
    }

    override fun onTabSelected(tab: TabLayout.Tab?) {
        val tabIconColor = ContextCompat.getColor(this, R.color.colorAccent)
        tab?.icon?.setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN)
    }
}
