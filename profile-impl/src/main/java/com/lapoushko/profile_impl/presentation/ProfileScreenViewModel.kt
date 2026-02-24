package com.lapoushko.profile_impl.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras
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