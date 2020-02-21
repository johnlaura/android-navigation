package com.johnlion.android_jatpack_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment? ?: return
        val navController = host.navController
        setupBottomNavMenu(navController)
//        loadNavigation(navController)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        //测试bottomNavigationView请把下行代码注释
        bottomNav.visibility = View.GONE

        bottomNav?.setupWithNavController(navController)
        bottomNav.setOnNavigationItemSelectedListener { item: MenuItem ->
            val options = NavOptions.Builder()
                .setPopUpTo(navController.currentDestination!!.id, true)
                .setLaunchSingleTop(true)
                .build()
            try {
                navController.navigate(item.itemId, null, options)
                true
            } catch (e: IllegalArgumentException) {
                false
            }
        }
    }

    //动态加载
    private fun loadNavigation(navController: NavController) {
        //测试时需要把activiy.xml中的app:navGraph="@navigation/mobile_navigation"去掉
        val navGraph: NavGraph =
            navController.navInflater.inflate(R.navigation.mobile_navigation)
        navController.graph = navGraph
    }

    //清栈
    private fun clearStack(navController: NavController) {
        navController.popBackStack(R.id.mobile_navigation, true)
    }
}
