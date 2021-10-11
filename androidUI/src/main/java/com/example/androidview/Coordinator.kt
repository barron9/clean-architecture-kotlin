package com.example.androidview

import android.app.Application
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import javax.inject.Inject

class Coordinator @Inject constructor(private val app: Application) {
    val finalHost = NavHostFragment.create(R.navigation.nav_file)
    var navController: NavHostController = NavHostController(app);
    fun navigate() {
        finalHost.navController
            .apply {
                navigate(R.id.page2)
            }
    }
}