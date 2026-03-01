package com.lapoushko.edit_profile_impl.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Medium
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.TooLightGray
import com.lapoushko.core_ui.theme.White
import com.lapoushko.edit_profile_impl.R
import com.lapoushko.edit_profile_impl.presentation.screen.EditProfileScreenState

@Composable
internal fun NameProfile(state: EditProfileScreenState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(White, shape = RoundedCornerShape(20.dp))
            .border(1.dp, TooLightGray, shape = RoundedCornerShape(20.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            AsyncImage(
                model = state.profile.imageUrl,
                error = painterResource(R.drawable.empty_user),
                contentDescription = "",
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(100.dp))
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                with(state.profile) {
                    Text(text = name.ifEmpty { "Нет имени" }, style = H4Medium, color = Black)
                    Text("Должность и специализация", style = H5Medium, color = LightGray)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EditProfileCardPreview(){
    NameProfile(EditProfileScreenState())
}