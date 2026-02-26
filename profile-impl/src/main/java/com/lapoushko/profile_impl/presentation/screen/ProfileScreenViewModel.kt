package com.lapoushko.profile_impl.presentation.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory

/**
 * @author Lapoushko
 */
internal class ProfileScreenViewModel: ViewModel() {
    var state by mutableStateOf(ProfileScreenState())
        private set

    companion object {
        val Factory = viewModelFactory {
            addInitializer(ProfileScreenViewModel::class) {
                ProfileScreenViewModel()
            }
        }
    }
}