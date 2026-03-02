package com.lapoushko.navigation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lapoushko.core_ui.theme.AppTypography
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.MainBlue
import com.lapoushko.core_ui.theme.MiddleGray
import com.lapoushko.core_ui.theme.TooLightGray
import com.lapoushko.navigation.graph.BottomNavigationGraph
import com.lapoushko.navigation.model.ScreenBar

/**
 * @author Lapoushko
 */

@Composable
fun BottomBarScreen(
    navController: NavHostController,
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val screens = listOf(
        ScreenBar.Main.route,
        ScreenBar.Catalog.route,
        ScreenBar.Favourite.route,
        ScreenBar.Cart.route,
        ScreenBar.Profile.route
    )

    val showBottomBar = currentDestination?.route in screens

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        bottomBar = {
            if (showBottomBar) {
                BottomBar(
                    navController = navController,
                )
            }
        }

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            BottomNavigationGraph(navController = navController)
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
) {
    val items = listOf(
        ScreenBar.Main,
        ScreenBar.Catalog,
        ScreenBar.Favourite,
        ScreenBar.Cart,
        ScreenBar.Profile
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val destination = navBackStackEntry?.destination

    NavigationBar(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 34.dp)
            .border(
                width = 1.dp,
                color = TooLightGray,
                shape = RoundedCornerShape(20.dp)
            ),
        containerColor = Color.Transparent,
        tonalElevation = 0.dp
    ) {
        items.forEach { screen ->

            val isSelected =
                destination?.hierarchy?.any { it.route == screen.route } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(screen.idIcon),
                        contentDescription = screen.title,
                        modifier = Modifier.size(36.dp),
                        tint = if (isSelected) MainBlue else LightGray
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                        style = AppTypography.H5Medium,
                        color = if (isSelected) MainBlue else MiddleGray,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                alwaysShowLabel = true,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MainBlue,
                    unselectedIconColor = LightGray,
                    selectedTextColor = MainBlue,
                    unselectedTextColor = MiddleGray,
                    indicatorColor = Color.Transparent,
                )
            )
        }
    }
}

@Composable
private fun RowScope.AddItem(
    screen: ScreenBar,
    destination: NavDestination?,
    navController: NavHostController,
    badges: Int = 0
) {
    val isSelected = destination?.hierarchy?.any { it.route == screen.route } == true

    Column(
        modifier = Modifier
            .weight(1f)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BadgedBox(
            badge = {

            }
        ) {
            CustomNavIcon(
                id = screen.idIcon,
                title = screen.title,
                isActive = isSelected
            )
        }
        Text(
            text = screen.title,
            color = if (isSelected) MainBlue else MiddleGray,
            style = AppTypography.H5Medium
        )
    }
}

@Composable
private fun CustomNavIcon(
    modifier: Modifier = Modifier,
    id: Int,
    title: String,
    isActive: Boolean
) {
    val tint = if (isActive) MainBlue else LightGray
    Icon(
        modifier = modifier.size(36.dp),
        painter = painterResource(id),
        contentDescription = title,
        tint = tint
    )
}
@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomBarScreen(
        navController = rememberNavController(),
    )
}