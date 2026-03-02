package com.lapoushko.edit_profile_impl.domain.usecase

import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.domain.repo.EditProfileRepository

internal interface SaveProfileUseCase{
    suspend operator fun invoke(profile: Profile)
}

internal class SaveProfileUseCaseImpl(
    private val repository: EditProfileRepository
): SaveProfileUseCase{
    override suspend fun invoke(profile: Profile) {
        repository.saveProfile(profile)
    }

}