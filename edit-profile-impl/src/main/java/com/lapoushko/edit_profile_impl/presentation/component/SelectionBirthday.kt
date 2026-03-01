package com.lapoushko.edit_profile_impl.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Regular
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.MiddleGray
import com.lapoushko.core_ui.theme.Orange
import com.lapoushko.core_ui.theme.Orange20
import com.lapoushko.core_ui.theme.SecondBlue
import com.lapoushko.core_ui.theme.SuperLightGray
import com.lapoushko.core_ui.theme.TooLightGray

@Composable
internal fun SelectionBirthday() {
    BackgroundColumnComponents(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        TextFieldBirthday()
        AcceptButton()
        WarningComponent()
    }
}

@Composable
private fun TextFieldBirthday() {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = "Дата рождения", style = H5Regular, color = MiddleGray)
        TextButton(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, TooLightGray, RoundedCornerShape(12.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = SuperLightGray,
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp)
            ) {
                Text(text = "12 ноя. 1985г.", style = H5Regular, color = Black)
                Text(text = "Изменить", style = H5Regular, color = SecondBlue)
            }
        }
    }
}

@Composable
private fun AcceptButton() {
    TextButton(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Orange20
        )
    ) {
        Text(
            text = "Подтвердить",
            style = H4Medium,
            color = Orange,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview(showBackground = false)
@Composable
private fun SelectionBirthdayPreview() {
    SelectionBirthday()
}