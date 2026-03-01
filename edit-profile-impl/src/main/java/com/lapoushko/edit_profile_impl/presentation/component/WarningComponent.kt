package com.lapoushko.edit_profile_impl.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H5Regular
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.edit_profile_impl.R

@Composable
internal fun WarningComponent(modifier: Modifier = Modifier){
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(R.drawable.question_circle), contentDescription = "question circle"
        )
        Text(text = "Подтвердите дату, если хотите получать бонусы в день вашего рождения", style = H5Regular, color = LightGray)
    }
}

@Preview
@Composable
private fun WarningComponentPreview(){
    WarningComponent()
}