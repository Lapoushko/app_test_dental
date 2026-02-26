package com.lapoushko.profile_impl.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lapoushko.core_ui.theme.AppTypography.H4Medium
import com.lapoushko.core_ui.theme.AppTypography.H5Medium
import com.lapoushko.core_ui.theme.Black
import com.lapoushko.core_ui.theme.LightGray
import com.lapoushko.core_ui.theme.MainBlue
import com.lapoushko.core_ui.theme.SecondBlue
import com.lapoushko.core_ui.theme.White
import com.lapoushko.profile_impl.R
import com.lapoushko.profile_impl.presentation.screen.ProfileScreenState

@Composable
internal fun ProfileCard(
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
            ContentInCardProfile(onClick = {}, content = {
                ContentCountBonus(state)
            })
            ContentInCardProfile(onClick = {}, content = {
                ContentFavouriteProducts(state)
            })
            ContentInCardProfile(onClick = {}, content = {
                ContentYourOrders(state)
            })
            ContentInCardProfile(onClick = {}, content = {
                ContentReviews()
            })
            ContentInCardProfile(onClick = {}, content = {
                ContentComparing(state)
            })
            ContentInCardProfile(onClick = {}, content = {
                ContentStats()
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
            verticalAlignment = Alignment.CenterVertically,
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
                    if (speciality == ProfileScreenState.Speciality.NONE && jobTitle == ProfileScreenState.JobTitle.NONE) {
                        Text("Должность и специализация", style = H5Medium, color = LightGray)
                    } else {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            Text(speciality.title, style = H5Medium, color = White)
                            Icon(
                                painterResource(R.drawable.circle_between_text),
                                contentDescription = "circle",
                                tint = White,
                                modifier = Modifier.size(3.dp)
                            )
                            Text(jobTitle.title, style = H5Medium, color = White)
                        }
                    }
                }
            }
        }
        Icon(
            modifier = Modifier.size(24.dp).clickable(onClick = {}),
            tint = White,
            painter = painterResource(R.drawable.pen_icon),
            contentDescription = "arrow back"
        )
    }
}

@Composable
private fun ContentInCardProfile(
    content: @Composable () -> Unit,
    onClick: () -> Unit,
) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Black.copy(alpha = 0.2f)
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ){
            content()
            IconButton(onClick = onClick) {
                Icon(
                    painter = painterResource(R.drawable.arrow_right_icon),
                    contentDescription = "on click",
                    tint = White
                )
            }
        }
    }
}

@Composable
private fun ContentCountBonus(
    state: ProfileScreenState
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.crown_line_icon),
            contentDescription = "crown line",
            tint = White
        )
        Text(text = "${state.bonus} бонусов", style = H4Medium, color = White)
    }
}

@Composable
private fun ContentFavouriteProducts(
    state: ProfileScreenState
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.favourite_icon),
            contentDescription = "favourites product",
            tint = White
        )
        Text(text = "Избранные товары", style = H4Medium, color = White)
        if (state.bonus > 0) {
            Text(
                text = "${state.bonus}",
                style = H4Medium,
                color = White,
                modifier = Modifier
                    .background(color = SecondBlue, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    }
}

@Composable
private fun ContentYourOrders(state: ProfileScreenState) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.your_orders_icon),
            contentDescription = "your orders",
            tint = White
        )
        Text(text = "Ваши заказы", style = H4Medium, color = White)
        if (state.countFeaturedProducts > 0) {
            Text(
                text = "${state.countFeaturedProducts}",
                style = H4Medium,
                color = White,
                modifier = Modifier
                    .background(color = SecondBlue, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp)
            )
        }
    }
}

@Composable
private fun ContentReviews() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.reviews_icon),
            contentDescription = "reviews",
            tint = White
        )
        Text(text = "Отзывы", style = H4Medium, color = White)
    }
}

@Composable
private fun ContentComparing(state: ProfileScreenState) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.compare_icon),
            contentDescription = "comparing",
            tint = White
        )
        Text(text = "Сравнить товары", style = H4Medium, color = White)
        if (state.countProductComparisons > 0) {
            Text(
                text = "${state.countProductComparisons}",
                style = H4Medium,
                color = White,
                modifier = Modifier
                    .background(color = SecondBlue, shape = RoundedCornerShape(6.dp))
                    .padding(horizontal = 6.dp, vertical = 2.dp)
            )
        }
    }
}

@Composable
private fun ContentStats() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(R.drawable.pie_chart_icon),
            contentDescription = "reviews",
            tint = White
        )
        Text(text = "Статистика", style = H4Medium, color = White)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProfileCardPreview() {
    ProfileCard(state = ProfileScreenState())
}