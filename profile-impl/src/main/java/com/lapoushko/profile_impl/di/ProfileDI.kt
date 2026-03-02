package com.lapoushko.profile_impl.di

import com.lapoushko.profile_impl.data.ProfileRepositoryImpl
import com.lapoushko.profile_impl.domain.repo.ProfileRepository
import com.lapoushko.profile_impl.domain.usecase.GetProfileUseCase
import com.lapoushko.profile_impl.domain.usecase.GetProfileUseCaseImpl
import com.lapoushko.profile_impl.presentation.screen.ProfileScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Lapoushko
 */
object ProfileDI {
    val module = module {
        viewModel { ProfileScreenViewModel(get()) }
        single<GetProfileUseCase> { GetProfileUseCaseImpl(get()) }
        single<ProfileRepository> { ProfileRepositoryImpl(get()) }
    }
}
