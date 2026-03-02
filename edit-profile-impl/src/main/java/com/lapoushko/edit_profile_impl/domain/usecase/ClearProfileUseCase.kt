package com.lapoushko.edit_profile_impl.domain.usecase

import com.lapoushko.edit_profile_impl.domain.repo.EditProfileRepository

internal interface ClearProfileUseCase {
    suspend operator fun invoke()
}

internal class ClearProfileUseCaseImpl(
    private val repository: EditProfileRepository
): ClearProfileUseCase{
    override suspend fun invoke() {
        repository.clearProfile()
    }

}