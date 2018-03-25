package io.gihub.karageageta.annicted.ui.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.gihub.karageageta.annicted.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        if (savedInstanceState == null) {
            val fragment = LoginFragment.newInstance()
            supportFragmentManager.beginTransaction().add(R.id.content, fragment).commit()
        }
    }
}
