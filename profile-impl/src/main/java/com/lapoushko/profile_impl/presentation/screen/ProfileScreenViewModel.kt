package com.lapoushko.profile_impl.presentation.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.viewModelFactory
import com.lapoushko.profile_impl.domain.usecase.GetProfileUseCase
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

/**
 * @author Lapoushko
 */
internal class ProfileScreenViewModel(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {
    var state by mutableStateOf(ProfileScreenState())
        private set

    init {
        observeData()
    }

    private fun observeData(){
        viewModelScope.launch {
            combine(
                getProfileUseCase(),
            ) {
                state.copy(
                    profile = it[0]
                )
            }
                .collect { newState ->
                    state = newState
                }
        }
    }

    companion object {
        val Factory = viewModelFactory {
            addInitializer(ProfileScreenViewModel::class) {
                val getProfileUseCase = requireNotNull(get(GET_PROFILE)) {
                    "Here initialized getProfileUseCase is null"
                }
                ProfileScreenViewModel(
                    getProfileUseCase = getProfileUseCase,
                )
            }
        }
        val GET_PROFILE = object : CreationExtras.Key<GetProfileUseCase> {}
    }
}