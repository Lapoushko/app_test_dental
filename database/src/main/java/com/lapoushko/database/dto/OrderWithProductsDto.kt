package com.lapoushko.database.dto

import androidx.room.Embedded
import androidx.room.Relation

/**
 * @author Lapoushko
 */
data class OrderWithProductsDto(
    @Embedded val order: OrderDto,

    @Relation(
        parentColumn = "idOrder",
        entityColumn = "orderId"
    )
    val products: List<ProductDto>
)