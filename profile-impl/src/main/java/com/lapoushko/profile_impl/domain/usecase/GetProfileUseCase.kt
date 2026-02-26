package com.lapoushko.profile_impl.domain.usecase

import android.util.Log
import com.lapoushko.profile_impl.domain.model.Profile
import com.lapoushko.profile_impl.domain.repo.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @author Lapoushko
 */
internal interface GetProfileUseCase{
    operator fun invoke(): Flow<Profile>
}

internal class GetProfileUseCaseImpl(
    private val repository: ProfileRepository
): GetProfileUseCase{
    override operator fun invoke(): Flow<Profile>{
        return repository.getProfile()
    }
}