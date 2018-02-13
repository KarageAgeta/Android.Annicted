package io.github.karageageta.annicted.ui.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.github.karageageta.annicted.R

class HomeActivity : AppCompatActivity() {
    private lateinit var fragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        if (savedInstanceState == null) {
            fragment = HomeFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.content, fragment).commit()
        } else {
            fragment = supportFragmentManager.findFragmentById(R.id.content) as HomeFragment
        }
    }
}
