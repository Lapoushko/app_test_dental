package com.lapoushko.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lapoushko.database.dao.ProfileDao
import com.lapoushko.database.dto.DeliveryAddressDto
import com.lapoushko.database.dto.OrderDto
import com.lapoushko.database.dto.ProductDto
import com.lapoushko.database.dto.ProfileDto

/**
 * @author Lapoushko
 */
@Database(
    entities = [OrderDto::class, ProductDto::class, ProfileDto::class, DeliveryAddressDto::class],
    version = ConstantsDatabase.TEST_TASK_DB_VERSION,
    exportSchema = false
)
internal abstract class AppDatabase :
    RoomDatabase() {
    abstract fun profileDao(): ProfileDao
}