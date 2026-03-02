package com.lapoushko.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Lapoushko
 */
@Entity(tableName = "orders")
data class OrderDto(
    @PrimaryKey
    val idOrder: Int,
    val status: String,
    val date: String
)