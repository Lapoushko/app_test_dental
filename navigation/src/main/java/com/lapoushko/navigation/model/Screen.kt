package com.lapoushko.navigation.model

import kotlinx.serialization.Serializable

/**
 * @author Lapoushko
 */
@Serializable
sealed class Screen {

    @Serializable
    data object Main : Screen()
    @Serializable
    data object Catalog: Screen()
    @Serializable
    data object Favourite: Screen()
    @Serializable
    data object Cart: Screen()
    @Serializable
    data object Profile: Screen()
}