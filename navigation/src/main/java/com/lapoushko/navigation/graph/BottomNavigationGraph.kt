package com.lapoushko.navigation.graph

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.lapoushko.navigation.model.Screen
import com.lapoushko.navigation.model.ScreenBar
import com.lapoushko.profile_impl.presentation.ProfileScreen

/**
 * @author Lapoushko
 */

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenBar.Main.route
    ) {
        val onBack: () -> Unit = {
            navController.popBackStack()
        }
        composable(ScreenBar.Main.route) {
            Text(modifier = Modifier.fillMaxSize(), text = "Главная")
        }
        composable(ScreenBar.Catalog.route) {
            Text(modifier = Modifier.fillMaxSize(), text = "Каталог")
        }
        composable(ScreenBar.Favourite.route) {
            Text(modifier = Modifier.fillMaxSize(), text = "Избранное")
        }
        composable(ScreenBar.Cart.route) {
            Text(modifier = Modifier.fillMaxSize(), text = "Корзина")
        }
        composable(ScreenBar.Profile.route) {
            ProfileScreen()
        }
    }
}