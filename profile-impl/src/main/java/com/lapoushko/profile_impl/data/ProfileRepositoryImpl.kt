package com.lapoushko.profile_impl.data

import com.lapoushko.database.dao.ProfileDao
import com.lapoushko.profile_impl.data.local.mapper.toDomain
import com.lapoushko.profile_impl.domain.model.Profile
import com.lapoushko.profile_impl.domain.repo.ProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

/**
 * @author Lapoushko
 */
internal class ProfileRepositoryImpl(
    private val dao: ProfileDao
): ProfileRepository {
    override fun getProfile(): Flow<Profile> {
        return dao.getProfile()
            .map { it?.toDomain() ?: Profile() }
            .flowOn(Dispatchers.IO)
    }
}