package com.lapoushko.app_test_dental

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.lapoushko.navigation.screen.BottomBarScreen

/**
 * @author Lapoushko
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
    }

    @Composable
    fun Host() {
        val navController = rememberNavController()
        BottomBarScreen(navController)
    }
}