package com.lapoushko.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Lapoushko
 */
@Entity(tableName = "delivery_addresses")
data class DeliveryAddressDto(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val address: String,
    val isSelected: Boolean
)