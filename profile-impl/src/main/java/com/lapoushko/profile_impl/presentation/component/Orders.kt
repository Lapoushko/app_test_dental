package com.lapoushko.profile_impl.presentation.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Regular
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.MiddleGray
import com.lapoushko.core_ui.theme.Orange
import com.lapoushko.core_ui.theme.Red
import com.lapoushko.core_ui.theme.TooLightGray
import com.lapoushko.profile_impl.R
import com.lapoushko.profile_impl.domain.Order
import com.lapoushko.profile_impl.presentation.screen.ProfileScreenState

@Composable
internal fun Orders(state: ProfileScreenState) {
    CurrentOrders(state)
}

@Composable
private fun CurrentOrders(state: ProfileScreenState) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                modifier = Modifier.size(20.dp),
                painter = painterResource(R.drawable.flame_icon),
                contentDescription = "flame",
                tint = Red
            )
            Text(text = "Текущие заказы", style = H4Medium, color = Black)
        }
        ListCurrentOrders(state.currentOrders)
    }
}

@Composable
private fun ListCurrentOrders(orders: List<Order>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(orders) { order ->
            OrderComponent(order)
        }
    }
}

@Composable
private fun OrderComponent(order: Order) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .border(1.dp, TooLightGray, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp)
    ) {
        Text(
            text = order.status.title,
            style = H5Regular,
            color = Orange,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Заказ #${order.idOrder}", style = H4Medium, color = Black)
            Text(text = order.date, style = H5Regular, color = MiddleGray)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(text = "${order.products.size} товаров", style = H5Regular, color = MiddleGray)
            Text(text = order.date, style = H5Regular, color = MiddleGray)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OrdersPreview() {
    Orders(state = ProfileScreenState().copy(currentOrders = listOf(Order())))
}