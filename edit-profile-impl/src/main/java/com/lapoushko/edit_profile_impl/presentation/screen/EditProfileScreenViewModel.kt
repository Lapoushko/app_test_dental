package com.lapoushko.edit_profile_impl.presentation.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.viewModelFactory
import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.domain.usecase.GetProfileUseCase
import com.lapoushko.edit_profile_impl.domain.usecase.SaveProfileUseCase
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

/**
 * @author Lapoushko
 */
internal class EditProfileScreenViewModel(
    private val getProfileUseCase: GetProfileUseCase,
    private val saveProfileUseCase: SaveProfileUseCase
) : ViewModel() {
    var state by mutableStateOf(EditProfileScreenState())
        private set

    init {
        observeData()
    }

    private fun observeData() {
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

    fun send(event: EditProfileScreenEvent) {
        when (event) {
            is EditProfileScreenEvent.ToggleProfileOptionEvent -> {
                toggleProfileOption(event.type)
            }

            is EditProfileScreenEvent.SelectProfileOptionEvent -> {
                selectProfileOption(event.option)
                state = state.copy(openedSheet = null)
            }

            is EditProfileScreenEvent.UpdateNameEvent -> {
                updateName(event.newName)
            }

            is EditProfileScreenEvent.SaveProfileEvent -> TODO()
        }
    }

    private fun toggleProfileOption(type: KClass<out Profile.ProfileOption>) {
        state = state.copy(
            openedSheet =
                if (state.openedSheet == type) null
                else type
        )
    }

    private fun selectProfileOption(option: Profile.ProfileOption) {
        val updatedProfile = when (option) {
            is Profile.WhoAreYou ->
                state.profile.copy(whoAreYou = option)

            is Profile.JobTitle ->
                state.profile.copy(jobTitle = option)

            is Profile.Speciality ->
                state.profile.copy(speciality = option)
        }

        updateProfile(updatedProfile)
    }

    private fun updateName(newName: String) {
        updateProfile(
            state.profile.copy(name = newName)
        )
    }

    private fun updateProfile(updatedProfile: Profile) {
        state = state.copy(profile = updatedProfile)

        viewModelScope.launch {
            saveProfileUseCase(updatedProfile)
        }
    }

    private fun saveProfile(){
        viewModelScope.launch {
            saveProfileUseCase.invoke(state.profile)
        }
    }

    companion object {
        val Factory = viewModelFactory {
            addInitializer(EditProfileScreenViewModel::class) {
                val getProfileUseCase = requireNotNull(get(GET_PROFILE)) {
                    "Here initialized getProfileUseCase is null"
                }
                val saveProfileUseCase = requireNotNull(get(SAVE_PROFILE)) {
                    "Here initialized saveProfileUseCase is null"
                }
                EditProfileScreenViewModel(
                    getProfileUseCase = getProfileUseCase,
                    saveProfileUseCase = saveProfileUseCase
                )
            }
        }
        val GET_PROFILE = object : CreationExtras.Key<GetProfileUseCase> {}
        val SAVE_PROFILE = object : CreationExtras.Key<SaveProfileUseCase> {}
    }
}