package com.lapoushko.profile_impl.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lapoushko.core_ui.theme.AppTypography.H4Bold
import com.lapoushko.core_ui.theme.AppTypography.H5Medium
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.MainBlue
import com.lapoushko.core_ui.theme.MainBlue10
import com.lapoushko.core_ui.theme.White
import com.lapoushko.profile_impl.R

/**
 * @author Lapoushko
 */
@Composable
fun ProfileScreen() {
    ProfileScreen(
        viewModel = viewModel(
            factory = ProfileScreenViewModel.Factory,
            extras = MutableCreationExtras().apply {}
        )
    )
}

@Composable
private fun ProfileScreen(
    viewModel: ProfileScreenViewModel
) {
    Scaffold(
        modifier = Modifier.padding(horizontal = 20.dp),
        topBar = {
            ProfileTopBar()
        }
    ) { innerPadding ->
        ProfileCard(modifier = Modifier.padding(innerPadding), state = viewModel.state)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ProfileTopBar(modifier: Modifier = Modifier) {
    @Composable
    fun CustomIcon(
        painter: Painter,
        contentDescription: String = "",
        onClick: () -> Unit = {}
    ) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .size(40.dp)
                .background(MainBlue10, RoundedCornerShape(10.dp))
        ) {
            Icon(
                painter = painter,
                contentDescription = contentDescription,
                modifier = Modifier.size(20.dp),
                tint = MainBlue
            )
        }
    }

    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "Личный кабинет", style = H4Bold)
        },
        navigationIcon = {
            Icon(
                modifier = Modifier.size(40.dp),
                tint = LightGray,
                painter = painterResource(R.drawable.arrow_left_icon),
                contentDescription = "arrow back"
            )
        },
        actions = {
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                CustomIcon(painter = painterResource(R.drawable.notification_icon))
                CustomIcon(painter = painterResource(R.drawable.actions_icon))
            }
        }
    )
}

@Composable
private fun ProfileCard(
    modifier: Modifier = Modifier,
    state: ProfileScreenState
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MainBlue, shape = RoundedCornerShape(20.dp)),
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            NameProfile(state)
            ContentInCardProfile(onClick = {}, state = state, content = {

            })
        }
    }
}

@Composable
private fun NameProfile(state: ProfileScreenState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.empty_user),
                contentDescription = "",
                modifier = Modifier
                    .size(52.dp)
                    .clip(RoundedCornerShape(100.dp))
            )
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                with(state) {
                    Text(text = name, style = H5Medium, color = White)
                    Text("$speciality $jobTitle", style = H5Medium, color = White)
                }
            }
        }
        Icon(
            modifier = Modifier.size(24.dp),
            tint = LightGray,
            painter = painterResource(R.drawable.pen_icon),
            contentDescription = "arrow back"
        )
    }
}

@Composable
private fun ContentInCardProfile(
    content: @Composable () -> Unit,
    onClick: () -> Unit,
    state: ProfileScreenState
) {
    Row(horizontalArrangement = Arrangement.SpaceEvenly) {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(R.drawable.arrow_right_icon),
                contentDescription = "on click",
                tint = White
            )
        }
    }
}

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}