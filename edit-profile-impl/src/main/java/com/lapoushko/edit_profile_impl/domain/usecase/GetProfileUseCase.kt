package com.lapoushko.edit_profile_impl.domain.usecase

import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.domain.repo.EditProfileRepository
import kotlinx.coroutines.flow.Flow

/**
 * @author Lapoushko
 */
internal interface GetProfileUseCase {
    operator fun invoke(): Flow<Profile>
}

internal class GetProfileUseCaseImpl(private val repository: EditProfileRepository
) : GetProfileUseCase {
    override operator fun invoke(): Flow<Profile> {
        return repository.getProfile()
    }
}