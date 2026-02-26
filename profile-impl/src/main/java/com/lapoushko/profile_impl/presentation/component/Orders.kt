package com.lapoushko.profile_impl.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Regular
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.GrayScale10
import com.lapoushko.core_ui.theme.MainBlue
import com.lapoushko.core_ui.theme.MainBlue10
import com.lapoushko.core_ui.theme.MiddleGray
import com.lapoushko.core_ui.theme.Orange
import com.lapoushko.core_ui.theme.Orange10
import com.lapoushko.core_ui.theme.Red
import com.lapoushko.core_ui.theme.SecondBlue
import com.lapoushko.core_ui.theme.SecondBlue10
import com.lapoushko.core_ui.theme.TooLightGray
import com.lapoushko.core_ui.theme.White
import com.lapoushko.core_ui.util.extractCityAndDeclensions
import com.lapoushko.profile_impl.R
import com.lapoushko.profile_impl.domain.model.DeliveryAddress
import com.lapoushko.profile_impl.domain.model.Order
import com.lapoushko.profile_impl.domain.model.Product
import com.lapoushko.profile_impl.presentation.screen.ProfileScreenState
import com.lapoushko.profile_impl.presentation.screen.ProfileScreenViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.math.roundToInt

@Composable
internal fun Orders(state: ProfileScreenState) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        CurrentOrders(state.currentOrders)
        HistoryOrders(state.historyOrders)
        DeliveryAddressesComponent(state.deliveryAddresses)
    }
}

@Composable
private fun CurrentOrders(currentOrders: List<Order>) {
    if (currentOrders.isNotEmpty()) {
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
            ListCurrentOrders(currentOrders, OrdersListType.CURRENT)
        }
    }
}

@Composable
private fun ListCurrentOrders(orders: List<Order>, ordersListType: OrdersListType) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        orders.forEach { order ->
            OrderComponent(order, ordersListType)
        }
    }
}

@Composable
private fun OrderComponent(order: Order, ordersListType: OrdersListType) {
    val colorButtonBackground = remember {
        when (ordersListType) {
            OrdersListType.CURRENT -> Orange
            OrdersListType.HISTORY -> SecondBlue10
        }
    }

    val colorButtonText = remember {
        when (ordersListType) {
            OrdersListType.CURRENT -> White
            OrdersListType.HISTORY -> SecondBlue
        }
    }
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
            Icon(
                painterResource(R.drawable.circle_between_text),
                contentDescription = "circle",
                tint = MiddleGray,
                modifier = Modifier.size(3.dp)
            )
            Text(
                text = "${order.products.sumOf { it.price }.roundToInt()} ₽",
                style = H5Regular,
                color = MiddleGray
            )
        }
        ListProducts(order.products)
        Button(
            onClick = {}, colors = ButtonDefaults.buttonColors(
                containerColor = colorButtonBackground,
                contentColor = colorButtonText
            ),
            shape = RoundedCornerShape(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Детали заказа", style = H4Medium)
        }
    }
}

@Composable
private fun ListProducts(products: List<Product>) {
    LazyRow(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(products) { product ->
            Card(
                modifier = Modifier
                    .size(64.dp)
                    .clickable { /* onClick */ },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = GrayScale10)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(46.dp),
                        model = product.imageUrl,
                        contentDescription = "product",
                        error = painterResource(R.drawable.example_product)
                    )
                }
            }
        }
    }
}

@Composable
private fun HistoryOrders(historyOrders: List<Order>) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "История заказов", style = H4Medium, color = Black)
            if (historyOrders.isNotEmpty()) {
                Text(
                    text = "Показать все",
                    style = H5Medium,
                    color = MainBlue,
                    modifier = Modifier.clickable(onClick = {})
                )
            }
        }
        if (historyOrders.isNotEmpty()) {
            ListCurrentOrders(historyOrders, OrdersListType.HISTORY)
            Button(
                onClick = {}, colors = ButtonDefaults.buttonColors(
                    containerColor = MainBlue10,
                    contentColor = MainBlue
                ),
                shape = RoundedCornerShape(12.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(text = "Показать все заказы", style = H4Medium)
            }
        } else {
            EmptyCardContent(
                painter = painterResource(R.drawable.empty_orders),
                text = "На данный момент у вас нет заказов",
                textButton = "Перейти в каталог"
            )
        }
    }
}

@Composable
private fun DeliveryAddressesComponent(deliveryAddresses: List<DeliveryAddress>) {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Адреса доставки", style = H4Medium, color = Black)
            if (deliveryAddresses.isNotEmpty()) {
                Text(
                    text = "Добавить новый",
                    style = H5Medium,
                    color = SecondBlue,
                    modifier = Modifier.clickable(onClick = {})
                )
            }

        }
        if (deliveryAddresses.isNotEmpty()) {
            ListDelivery(deliveryAddresses)
        } else {
            EmptyCardContent(
                painter = painterResource(R.drawable.map_point),
                text = "Вы не добавили адреса доставки",
                textButton = "Добавить адрес"
            )
        }
    }
}

@Composable
private fun ListDelivery(deliveryAddresses: List<DeliveryAddress>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        items(deliveryAddresses) { deliveryAddress ->
            DeliveryComponent(deliveryAddress)
        }
    }
}

@Composable
private fun DeliveryComponent(deliveryAddress: DeliveryAddress) {
    val colorButtonBackground = remember {
        if (deliveryAddress.isSelected) {
            return@remember Orange10
        } else return@remember Color.Transparent
    }
    Button(
        onClick = {},
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorButtonBackground
        ),
        border = if (!deliveryAddress.isSelected) BorderStroke(
            1.dp,
            color = TooLightGray
        ) else BorderStroke(0.dp, color = Color.Transparent)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (deliveryAddress.isSelected) {
                        Icon(
                            painter = painterResource(R.drawable.crown_minimalistic_icon),
                            contentDescription = "crown minimalistic",
                            modifier = Modifier.size(16.dp),
                            tint = Orange
                        )
                    }
                    Text(
                        modifier = Modifier.width(220.dp),
                        text = "Доставка по ${deliveryAddress.address.extractCityAndDeclensions()?.dative}",
                        style = H4Medium,
                        color = Black
                    )
                }
                Text(
                    text = "Изменить",
                    style = H5Medium,
                    color = SecondBlue,
                    modifier = Modifier.clickable(onClick = {})
                )
            }
            Text(text = deliveryAddress.address, style = H5Regular, color = MiddleGray)
        }
    }
}

@Composable
private fun EmptyCard(content: @Composable () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, TooLightGray, shape = RoundedCornerShape(16.dp))
            .padding(vertical = 16.dp)
    ) {
        content()
    }
}

@Composable
private fun EmptyCardContent(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    textButton: String
) {
    EmptyCard {
        Column(
            modifier = modifier
                .padding(vertical = 52.dp)
                .wrapContentSize(Alignment.Center),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painter,
                    contentDescription = "empty card",
                    modifier = Modifier.size(60.dp)
                )
                Text(
                    text = text,
                    style = H5Medium,
                    color = MiddleGray
                )
            }
            Button(
                onClick = {},
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = MainBlue,
                    containerColor = SecondBlue10
                ),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Text(text = textButton, style = H4Medium)
            }
        }
    }
}

private sealed interface OrdersListType {
    data object CURRENT : OrdersListType
    data object HISTORY : OrdersListType
}

@Preview(showBackground = true)
@Composable
private fun OrdersPreview() {
    Orders(state = ProfileScreenState())
}
