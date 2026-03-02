package com.lapoushko.edit_profile_impl.presentation.di

import com.lapoushko.edit_profile_impl.data.local.repo.EditProfileRepositoryImpl
import com.lapoushko.edit_profile_impl.domain.repo.EditProfileRepository
import com.lapoushko.edit_profile_impl.domain.usecase.ClearProfileUseCase
import com.lapoushko.edit_profile_impl.domain.usecase.ClearProfileUseCaseImpl
import com.lapoushko.edit_profile_impl.domain.usecase.GetProfileUseCase
import com.lapoushko.edit_profile_impl.domain.usecase.GetProfileUseCaseImpl
import com.lapoushko.edit_profile_impl.domain.usecase.SaveProfileUseCase
import com.lapoushko.edit_profile_impl.domain.usecase.SaveProfileUseCaseImpl
import com.lapoushko.edit_profile_impl.presentation.screen.EditProfileScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Lapoushko
 */
object EditProfileDI {
    val module = module {
        viewModel { EditProfileScreenViewModel(get(), get(), get()) }
        single<GetProfileUseCase> { GetProfileUseCaseImpl(get()) }
        single<ClearProfileUseCase> { ClearProfileUseCaseImpl(get()) }
        single<SaveProfileUseCase> { SaveProfileUseCaseImpl(get()) }
        single<EditProfileRepository> { EditProfileRepositoryImpl(get()) }
    }
}