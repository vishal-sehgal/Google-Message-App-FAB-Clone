package com.developervishalsehgal.googlemessageapp

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Setting Light Status Bar
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            window.statusBarColor = Color.WHITE
        } else {
            window.statusBarColor = Color.BLACK
        }


        //Setting up Toolbar
        setSupportActionBar(main_toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)


        val fragment = MainFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_main, fragment)
        transaction.commit()
    }

    fun getAppbarLayout(): AppBarLayout {
        return appbar
    }

    fun getChatFabTitle(): TextView? {
        return chat_fab_text
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

}