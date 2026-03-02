@file:OptIn(ExperimentalMaterial3Api::class)

package com.lapoushko.edit_profile_impl.presentation.component


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H3Medium
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Regular
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.MiddleGray
import com.lapoushko.core_ui.theme.SecondBlue
import com.lapoushko.core_ui.theme.SecondBlue10
import com.lapoushko.core_ui.theme.SecondBlue20
import com.lapoushko.core_ui.theme.SuperLightGray
import com.lapoushko.core_ui.theme.TooLightGray
import com.lapoushko.edit_profile_impl.R
import com.lapoushko.edit_profile_impl.domain.model.Profile
import com.lapoushko.edit_profile_impl.presentation.screen.UpdateSheetHandler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SelectionDataProfile(
    profile: Profile,
    onValueChangeTextField: (String) -> Unit,
    whoAreYouHandler: UpdateSheetHandler<Profile.WhoAreYou>,
    jobTitleHandler: UpdateSheetHandler<Profile.JobTitle>,
    specialityHandler: UpdateSheetHandler<Profile.Speciality>
) {
    BackgroundColumnComponents(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextFieldChoiceComponent(
            value = profile.whoAreYou.title,
            label = whoAreYouHandler.title,
            handler = whoAreYouHandler
        )
        TextFieldComponent(
            value = profile.name,
            label = "ФИО",
            onValueChange = { onValueChangeTextField(it) }
        )
        TextFieldChoiceComponent(
            value = profile.jobTitle.title,
            label = jobTitleHandler.title,
            handler = jobTitleHandler
        )
        TextFieldChoiceComponent(
            value = profile.speciality.title,
            label = specialityHandler.title,
            handler = specialityHandler
        )
    }
}

@Composable
private fun <T : Profile.ProfileOption> TextFieldChoiceComponent(
    handler: UpdateSheetHandler<T>,
    value: String,
    label: String
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, style = H5Regular, color = MiddleGray)
        TextButton(
            onClick = { handler.onToggle() },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.textButtonColors(
                containerColor = SuperLightGray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, shape = RoundedCornerShape(12.dp), color = TooLightGray)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Text(text = value, style = H5Regular, color = Black)
                Icon(
                    painter = painterResource(R.drawable.alt_arrow_down),
                    contentDescription = "arrow down",
                    tint = MiddleGray
                )
            }
        }
    }
    if (handler.isOpened) {
        BottomSheetComponent(
            handler = handler
        )
    }
}

@Composable
private fun <T : Profile.ProfileOption> BottomSheetComponent(
    handler: UpdateSheetHandler<T>
) {
    val sheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { handler.onToggle() },
        sheetState = sheetState,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = handler.title, style = H3Medium, color = Black)

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                handler.items.filter { it.isSelectable }.forEach { item ->

                    val isSelected = item == handler.selected

                    TextButton(
                        onClick = {
                            handler.onSelected(item)
                            handler.onToggle()
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = if (isSelected) SecondBlue10 else SuperLightGray,
                            contentColor = if (isSelected) SecondBlue else MiddleGray
                        ),
                        modifier = Modifier
                            .border(
                                1.dp,
                                color = if (isSelected) SecondBlue20 else TooLightGray,
                                shape = RoundedCornerShape(16.dp)
                            )
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp, horizontal = 20.dp)
                        ) {
                            Text(
                                text = item.title,
                                style = H4Medium,
                            )
                            if (isSelected) {
                                Icon(
                                    painter = painterResource(R.drawable.check_circle),
                                    contentDescription = "check circle",
                                    modifier = Modifier.size(21.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TextFieldComponent(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, style = H5Regular, color = MiddleGray)
        TextField(
            value = value,
            onValueChange = { onValueChange(it) },
            shape = RoundedCornerShape(12.dp),
            textStyle = H5Regular,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = SuperLightGray,
                unfocusedContainerColor = SuperLightGray,
                disabledContainerColor = SuperLightGray,
                unfocusedTextColor = Black,
                focusedTextColor = Black,
                disabledTextColor = Black,

                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(text = value.ifEmpty { "Нет имени" }, style = H5Regular, color = Black)
            },
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, shape = RoundedCornerShape(12.dp), color = TooLightGray)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun BottomSheetPreview() {
    BottomSheetComponent(handler = UpdateSheetHandler<Profile.WhoAreYou>())
}

@Preview(showBackground = true)
@Composable
private fun SelectionDataProfilePreview() {
    SelectionDataProfile(
        profile = Profile(),
        onValueChangeTextField = {},
        specialityHandler = UpdateSheetHandler(),
        whoAreYouHandler = UpdateSheetHandler(),
        jobTitleHandler = UpdateSheetHandler()
    )
}