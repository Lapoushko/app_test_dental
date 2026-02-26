package com.lapoushko.profile_impl.domain.repo

import com.lapoushko.profile_impl.domain.model.Profile
import kotlinx.coroutines.flow.Flow

/**
 * @author Lapoushko
 */
internal interface ProfileRepository {
    fun getProfile(): Flow<Profile>
}