package com.lapoushko.profile_impl.di

import com.lapoushko.profile_impl.presentation.screen.ProfileScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Lapoushko
 */
object ProfileDI{
    val module = module {
        viewModel { ProfileScreenViewModel() }
    }
}
