package com.lapoushko.edit_profile_impl.presentation.screen

import com.lapoushko.edit_profile_impl.domain.model.Profile
import kotlin.reflect.KClass

/**
 * @author Lapoushko
 */
internal data class EditProfileScreenState(
    val profile: Profile = Profile(),
    val openedSheet: KClass<out Profile.ProfileOption>? = null
)

internal class UpdateSheetHandler<T : Profile.ProfileOption>(
    val title: String = "title",
    val items: List<T> = emptyList(),
    val selected: T? = null,
    val isOpened: Boolean = false,
    val onToggle: () -> Unit = {},
    val onSelected: (T) -> Unit = {}
)