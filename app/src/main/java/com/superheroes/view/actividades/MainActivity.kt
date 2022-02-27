package com.superheroes.view.actividades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.superheroes.R

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        navController!!.setGraph(R.navigation.mobile_navigation)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_descripcion
        ))

        setupActionBarWithNavController(navController!!, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController!!.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}