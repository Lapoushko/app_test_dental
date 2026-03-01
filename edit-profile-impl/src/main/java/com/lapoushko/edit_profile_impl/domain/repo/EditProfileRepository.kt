package com.lapoushko.edit_profile_impl.domain.repo

import com.lapoushko.edit_profile_impl.domain.model.Profile
import kotlinx.coroutines.flow.Flow

/**
 * @author Lapoushko
 */
internal interface EditProfileRepository {
    fun getProfile(): Flow<Profile>

    suspend fun saveProfile(profile: Profile)
}