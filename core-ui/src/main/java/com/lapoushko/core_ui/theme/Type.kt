package com.lapoushko.core_ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lapoushko.core_ui.R

// Set of Material typography styles to start with
object AppTypography {

    // -------------------- 28 --------------------
    val H1Bold = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp
    )

    val H1Medium = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp
    )

    val H1Regular = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    )

    // -------------------- 24 --------------------
    val H2Bold = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )

    val H2Medium = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    )

    val H2Regular = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    )

    // -------------------- 20 --------------------
    val H3Bold = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

    val H3Medium = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp
    )

    val H3Regular = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )

    // -------------------- 16 --------------------
    val H4Bold = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp
    )

    val H4Medium = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp
    )

    val H4Regular = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    // -------------------- 12 --------------------
    val H5Bold = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp
    )

    val H5Medium = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp
    )

    val H5Regular = TextStyle(
        fontFamily = Geologica,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
}

val Typography = Typography(
    headlineLarge = AppTypography.H1Bold,
    headlineMedium = AppTypography.H2Bold,
    headlineSmall = AppTypography.H3Bold,
    titleLarge = AppTypography.H4Medium,
    bodyLarge = AppTypography.H4Regular,
    labelSmall = AppTypography.H5Regular
)