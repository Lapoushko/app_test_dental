package com.lapoushko.profile_impl.presentation.screen

import com.lapoushko.profile_impl.domain.model.DeliveryAddress
import com.lapoushko.profile_impl.domain.model.Order
import com.lapoushko.profile_impl.domain.model.Product
import com.lapoushko.profile_impl.domain.model.Profile

/**
 * @author Lapoushko
 */
internal data class ProfileScreenState(
    val profile: Profile = Profile(),
    val bonus: Int = 0,
    val countFeaturedProducts: Int = 0,
    val countOrders: Int = 0,
    val countProductComparisons: Int = 0,
    val moneyInWallet: Int = 0,
    val unreadMessages: Int = 0,
    val currentOrders: List<Order> = listOf(Order().copy(products = listOf(Product()))),
    val historyOrders: List<Order> = listOf(Order()),
    val deliveryAddresses: List<DeliveryAddress> = listOf(
        DeliveryAddress().copy(isSelected = true),
        DeliveryAddress()
    )
)