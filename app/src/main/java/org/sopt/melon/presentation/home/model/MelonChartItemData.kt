package org.sopt.melon.presentation.home.model

import org.sopt.melon.data.model.HomeMusic

data class MelonChartItemData(
    val imgUrl: String,
    val title: String,
    val singer: String,
)

fun HomeMusic.toMelonChartItemData(): MelonChartItemData =
    MelonChartItemData(
        imgUrl = imageUrl,
        title = title,
        singer = artistName,
    )
