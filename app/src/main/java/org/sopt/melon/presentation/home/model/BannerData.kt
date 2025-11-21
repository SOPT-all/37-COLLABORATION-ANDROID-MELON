package org.sopt.melon.presentation.home.model

import androidx.compose.ui.graphics.Color

data class BannerData(
    val title: String,
    val image: Int,
    val category: String,
    val headline: String,
    val description: String,
    val backgroundColor: Color,
)
