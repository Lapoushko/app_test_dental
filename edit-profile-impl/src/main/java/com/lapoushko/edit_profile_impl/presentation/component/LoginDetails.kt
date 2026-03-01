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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Regular
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.MiddleGray
import com.lapoushko.core_ui.theme.Orange
import com.lapoushko.core_ui.theme.Orange20
import com.lapoushko.core_ui.theme.SecondBlue
import com.lapoushko.core_ui.theme.SecondBlue10
import com.lapoushko.core_ui.theme.SuperLightGray
import com.lapoushko.core_ui.theme.TooLightGray

@Composable
internal fun LoginDetails(modifier: Modifier = Modifier) {
    BackgroundColumnComponents(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        ContactComponent(
            label = "Номер телефона",
            value = "+7 (915) 560-89-90",
            buttonText = "Изменить",
            colorButton = SecondBlue,
        )
        ContactComponent(
            label = "Электронная почта",
            value = "rt***@gmail.com",
            buttonText = "Подтвердить",
            colorButton = Orange,
        )
        LoginSettings()
    }
}

@Composable
private fun ContactComponent(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    buttonText: String,
    colorButton: Color
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(text = label, style = H5Regular, color = MiddleGray)
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
                Text(text = value, style = H5Regular, color = Black)
                Text(text = buttonText, style = H5Regular, color = colorButton)
            }
        }
    }
}

@Composable
private fun LoginSettings(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginSettingsButton(
            value = "Настроить вход по Face ID"
        )
        LoginSettingsButton(
            value = "Изменить пароль"
        )
        Text(
            text = "Последняя смена пароля была 3 мес. назад",
            style = H5Regular,
            color = LightGray
        )
    }
}

@Composable
private fun LoginSettingsButton(
    value: String,
) {
    TextButton(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = SecondBlue10
        )
    ) {
        Text(
            text = value,
            style = H4Medium,
            color = SecondBlue,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Preview
@Composable
private fun LoginDetailsPreview() {
    LoginDetails()
}