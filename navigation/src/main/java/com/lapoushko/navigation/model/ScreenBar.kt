package com.lapoushko.navigation.model

import com.lapoushko.navigation.R

/**
 * @author Lapoushko
 */
sealed class ScreenBar(
    val route: String,
    val title: String,
    val idIcon: Int
) {

    data object Main : ScreenBar(
        route = MAIN_ROUTE,
        title = MAIN_TITLE,
        idIcon = MAIN_ID_ICON
    )


    data object Catalog : ScreenBar(
        route = CATALOG_ROUTE,
        title = CATALOG_TITLE,
        idIcon = CATALOG_ID_ICON
    )

    data object Favourite : ScreenBar(
        route = FAVOURITE_ROUTE,
        title = FAVOURITE_TITLE,
        idIcon = FAVOURITE_ID_ICON
    )

    data object Cart : ScreenBar(
        route = CART_ROUTE,
        title = CART_TITLE,
        idIcon = CART_ID_ICON
    )

    data object Profile : ScreenBar(
        route = PROFILE_ROUTE,
        title = PROFILE_TITLE,
        idIcon = PROFILE_ID_ICON
    )

    companion object {
        private const val MAIN_ROUTE = "MAIN"
        private const val MAIN_TITLE = "Главная"
        private val MAIN_ID_ICON = R.drawable.main_icon

        private const val CATALOG_ROUTE = "CATALOG"
        private const val CATALOG_TITLE = "Каталог"
        private val CATALOG_ID_ICON = R.drawable.catalog_icon

        private const val FAVOURITE_ROUTE = "FAVOURITE"
        private const val FAVOURITE_TITLE = "Избранное"
        private val FAVOURITE_ID_ICON = R.drawable.favourite_icon

        private const val CART_ROUTE = "CART"
        private const val CART_TITLE = "Корзина"
        private val CART_ID_ICON = R.drawable.cart_icon

        private const val PROFILE_ROUTE = "profile"
        private const val PROFILE_TITLE = "Профиль"
        private val PROFILE_ID_ICON = R.drawable.user_icon
    }
}