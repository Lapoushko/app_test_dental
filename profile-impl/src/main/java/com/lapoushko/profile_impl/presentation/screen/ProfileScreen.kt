package com.lapoushko.profile_impl.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.MutableCreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.lapoushko.core_ui.theme.AppTypography.H4Bold
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.MainBlue
import com.lapoushko.core_ui.theme.MainBlue10
import com.lapoushko.profile_impl.R
import com.lapoushko.profile_impl.presentation.component.Orders
import com.lapoushko.profile_impl.presentation.component.ProfileCard
import com.lapoushko.profile_impl.presentation.component.WalletAndChat

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
    val scrollState = rememberScrollState()
    val state = viewModel.state
    Scaffold(
        modifier = Modifier.padding(horizontal = 20.dp),
        topBar = {
            ProfileTopBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(18.dp)
        ) {
            ProfileCard(state = state)
            WalletAndChat(state = state)
            Orders(state)
        }
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

@Preview
@Composable
private fun ProfileScreenPreview() {
    ProfileScreen()
}