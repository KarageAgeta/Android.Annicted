package io.github.karageageta.annicted.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.karageageta.annicted.R
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.ActionBarDrawerToggle
import android.support.design.widget.NavigationView

class MainActivity : AppCompatActivity() {

    private val select = NavigationView.OnNavigationItemSelectedListener {
        drawer.closeDrawers()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        view_pager.also {
            it.adapter = MainTabPagerAdapter(supportFragmentManager, this)
            tab.setupWithViewPager(it)
        }

        ActionBarDrawerToggle(this, drawer, toolbar, R.string.app_name, R.string.app_name).also {
            drawer.setDrawerListener(it)
            it.syncState()
        }

        drawer_navigation.setNavigationItemSelectedListener(select)
    }
}
