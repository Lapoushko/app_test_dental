package com.lapoushko.database.dto

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Lapoushko
 */
@Entity(tableName = "profile")
data class ProfileDto(
    @PrimaryKey
    val id: Int = 0,
    val name: String,
    val whoAreYou: String,
    val jobTitle: String,
    val speciality: String
)