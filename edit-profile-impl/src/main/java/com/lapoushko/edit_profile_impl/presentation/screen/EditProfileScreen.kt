package com.lapoushko.edit_profile_impl.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lapoushko.core_ui.theme.AppTypography.H4Bold
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.SuperLightGray
import com.lapoushko.edit_profile_impl.R
import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.domain.usecase.GetProfileUseCase
import com.lapoushko.edit_profile_impl.domain.usecase.SaveProfileUseCase
import com.lapoushko.edit_profile_impl.presentation.component.LoginDetails
import com.lapoushko.edit_profile_impl.presentation.component.NameProfile
import com.lapoushko.edit_profile_impl.presentation.component.SelectionBirthday
import com.lapoushko.edit_profile_impl.presentation.component.SelectionDataProfile
import org.koin.compose.getKoin

/**
 * @author Lapoushko
 */
@Composable
fun EditProfileScreen(
    onBack: () -> Unit
) {
    EditProfileScreen(
        viewModel = viewModel(
            factory = EditProfileScreenViewModel.Factory, extras = MutableCreationExtras().apply {
                set(
                    EditProfileScreenViewModel.GET_PROFILE, getKoin().get<GetProfileUseCase>()
                )
                set(
                    EditProfileScreenViewModel.SAVE_PROFILE, getKoin().get<SaveProfileUseCase>()
                )
            }), onBack = onBack
    )
}

@Composable
private fun EditProfileScreen(
    viewModel: EditProfileScreenViewModel, onBack: () -> Unit
) {
    val state = viewModel.state
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { EditProfileTopBar(onBack = onBack) },
        containerColor = SuperLightGray
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                NameProfile(
                    state = state,
                )
            }
            item {
                SelectionDataProfile(
                    profile = state.profile,
                    onValueChangeTextField = {
                        viewModel.send(
                            EditProfileScreenEvent.UpdateNameEvent(
                                it
                            )
                        )
                    },
                    whoAreYouHandler = UpdateSheetHandler(
                        title = "Кто вы?",
                        items = Profile.WhoAreYou.values().toList(),
                        isOpened = state.openedSheet == Profile.WhoAreYou::class,
                        onToggle = {
                            viewModel.send(
                                EditProfileScreenEvent.ToggleProfileOptionEvent(
                                    Profile.WhoAreYou::class
                                )
                            )
                        },
                        selected = state.profile.whoAreYou,
                        onSelected = {
                            viewModel.send(
                                EditProfileScreenEvent.SelectProfileOptionEvent(it)
                            )
                        }), jobTitleHandler = UpdateSheetHandler(
                        title = "Должность",
                        items = Profile.JobTitle.values().toList(),
                        isOpened = state.openedSheet == Profile.JobTitle::class,
                        onToggle = {
                            viewModel.send(
                                EditProfileScreenEvent.ToggleProfileOptionEvent(
                                    Profile.JobTitle::class
                                )
                            )
                        },
                        selected = state.profile.jobTitle,
                        onSelected = {
                            viewModel.send(
                                EditProfileScreenEvent.SelectProfileOptionEvent(it)
                            )
                        }),

                    specialityHandler = UpdateSheetHandler(
                        title = "Специальность",
                        items = Profile.Speciality.values().toList(),
                        isOpened = state.openedSheet == Profile.Speciality::class,
                        onToggle = {
                            viewModel.send(
                                EditProfileScreenEvent.ToggleProfileOptionEvent(
                                    Profile.Speciality::class
                                )
                            )
                        },
                        selected = state.profile.speciality,
                        onSelected = {
                            viewModel.send(
                                EditProfileScreenEvent.SelectProfileOptionEvent(it)
                            )
                        })
                )
            }
            item {
                SelectionBirthday()
            }
            item { LoginDetails() }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun EditProfileTopBar(modifier: Modifier = Modifier, onBack: () -> Unit) {
    TopAppBar(modifier = modifier, title = {
        Text(text = "Личный кабинет", style = H4Bold)
    }, navigationIcon = {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .padding(horizontal = 20.dp)
                .clickable(onClick = onBack),
            painter = painterResource(R.drawable.arrow_left_icon),
            contentDescription = "arrow back",
            tint = Black
        )
    })
}

@Preview(showBackground = true)
@Composable
private fun EditProfileScreenPreview() {
    EditProfileScreen(onBack = {})
}