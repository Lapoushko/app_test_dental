package com.lapoushko.edit_profile_impl.presentation.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

/**
 * @author Lapoushko
 */
@Composable
fun EditProfileScreen() {
    EditProfileScreen(
        viewModel = viewModel(
            factory = EditProfileViewModel.Factory,
            extras =
        ) { }
    )
}

@Composable
private fun EditProfileScreen(
    viewModel: EditProfileViewModel
) {
}

@Preview(showBackground = true)
@Composable
private fun EditProfileScreenPreview(){
    EditProfileScreen()
}