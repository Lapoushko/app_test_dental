package com.lapoushko.edit_profile_impl.data.local.repo

import com.lapoushko.database.dao.ProfileDao
import com.lapoushko.edit_profile_impl.data.local.mapper.toDomain
import com.lapoushko.edit_profile_impl.data.local.mapper.toDto
import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.domain.repo.EditProfileRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

internal class EditProfileRepositoryImpl(
    private val dao: ProfileDao
): EditProfileRepository {
    override fun getProfile(): Flow<Profile> {
        return dao.getProfile()
            .map { it?.toDomain() ?: Profile() }
            .flowOn(Dispatchers.IO)
    }

    override suspend fun saveProfile(profile: Profile) {
        withContext(Dispatchers.IO){
            dao.insert(profile.toDto())
        }
    }
}