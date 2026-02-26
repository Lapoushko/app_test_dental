package com.lapoushko.profile_impl.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.MainBlue
import com.lapoushko.core_ui.theme.MainBlue10
import com.lapoushko.core_ui.theme.MainBlue60
import com.lapoushko.core_ui.theme.SecondBlue
import com.lapoushko.core_ui.theme.SecondBlue10
import com.lapoushko.core_ui.theme.White
import com.lapoushko.profile_impl.R
import com.lapoushko.profile_impl.presentation.screen.ProfileScreenState

@Composable
internal fun WalletAndChat(state: ProfileScreenState){
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Wallet(state)
        ChatWithManager(state)
    }
}

@Composable
private fun Wallet(state: ProfileScreenState) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = SecondBlue10,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 17.dp)
        ) {
            Text(
                text = "Кошелек", style = H4Medium, color = Black,
            )
            if (state.moneyInWallet > 0) {
                Text(
                    text = "${state.moneyInWallet}", style = H4Medium, color = SecondBlue,
                    modifier = Modifier
                        .background(
                            color = White,
                            shape = RoundedCornerShape(5.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.5.dp)
                )
            }
        }
        Icon(
            painter = painterResource(R.drawable.wallet_icon),
            tint = SecondBlue,
            contentDescription = "wallet",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
private fun ChatWithManager(state: ProfileScreenState) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(
                color = MainBlue10,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(horizontal = 14.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 17.dp)
        ) {
            Text(
                text = "Чат с менеджером", style = H4Medium, color = Black,
            )
            if (state.unreadMessages > 0) {
                Text(
                    text = "${state.unreadMessages}", style = H4Medium, color = White,
                    modifier = Modifier
                        .background(
                            color = MainBlue,
                            shape = RoundedCornerShape(90.dp)
                        )
                        .padding(horizontal = 6.dp, vertical = 2.5.dp)
                )
            }
        }
        Icon(
            painter = painterResource(R.drawable.chat_icon),
            tint = MainBlue60,
            contentDescription = "wallet",
            modifier = Modifier.size(30.dp)
        )
    }
}