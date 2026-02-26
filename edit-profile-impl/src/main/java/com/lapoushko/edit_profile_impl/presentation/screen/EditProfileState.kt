package com.lapoushko.edit_profile_impl.presentation.screen

import com.lapoushko.edit_profile_impl.domain.model.Profile

/**
 * @author Lapoushko
 */
internal data class EditProfileState(
    val profile: Profile,
    val isSelectedWhoAraYou: Boolean,
    val isSelectedJobTitle: Boolean,
    val isSelectedSpeciality: Boolean,
)