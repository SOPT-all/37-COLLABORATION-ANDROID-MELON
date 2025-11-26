package org.sopt.melon.presentation.home.model

import org.sopt.melon.data.model.HomeMusic

data class PopularSongData(
    val imgUrl: String,
    val subtitle: String,
    val title: String,
    val artistName: String,
)

fun HomeMusic.toPopularSongData() {
    val subtitle = when (index % 3) {
        0 -> "멜론DJ’s Pick"
        1 -> "검색 트렌드"
        2 -> "HOT100 7위"
        else -> ""
    }

    PopularSongData(
        imgUrl = imageUrl,
        subtitle = subtitle,
        title = title,
        artistName = artistName,
    )
}
