package com.lapoushko.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lapoushko.database.dto.ProfileDto
import kotlinx.coroutines.flow.Flow

/**
 * @author Lapoushko
 */
@Dao
interface ProfileDao {

    @Query("SELECT * FROM profile LIMIT 1")
    fun getProfile(): Flow<ProfileDto?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(profile: ProfileDto)

    @Query("DELETE FROM profile")
    suspend fun clear()
}