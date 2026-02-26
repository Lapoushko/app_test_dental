package com.lapoushko.database.dto

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**
 * @author Lapoushko
 */
@Entity(
    tableName = "products",
    foreignKeys = [
        ForeignKey(
            entity = OrderDto::class,
            parentColumns = ["idOrder"],
            childColumns = ["orderId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("orderId")]
)
data class ProductDto(
    @PrimaryKey
    val id: Long,
    val orderId: Int,
    val price: Double,
    val imageUrl: String
)