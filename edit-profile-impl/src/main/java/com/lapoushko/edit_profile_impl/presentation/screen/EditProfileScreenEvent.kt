package com.lapoushko.edit_profile_impl.presentation.screen

import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.domain.repo.EditProfileRepository
import kotlin.reflect.KClass

/**
 * @author Lapoushko
 */
internal sealed interface EditProfileScreenEvent {
    data class ToggleProfileOptionEvent(
        val type: KClass<out Profile.ProfileOption>
    ) : EditProfileScreenEvent

    data class SelectProfileOptionEvent(
        val option: Profile.ProfileOption
    ) : EditProfileScreenEvent

    data class UpdateNameEvent(val newName: String): EditProfileScreenEvent

    data class SaveProfileEvent(val profile: Profile): EditProfileScreenEvent
}