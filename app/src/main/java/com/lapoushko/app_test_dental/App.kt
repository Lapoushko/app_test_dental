package com.lapoushko.app_test_dental

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.lapoushko.database.di.DatabaseDI
import com.lapoushko.navigation.screen.BottomBarScreen
import com.lapoushko.profile_impl.di.ProfileDI
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * @author Lapoushko
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                ProfileDI.module,
                DatabaseDI.module
            )
        }
    }

    @Composable
    fun Host() {
        val navController = rememberNavController()
        BottomBarScreen(navController)
    }
}