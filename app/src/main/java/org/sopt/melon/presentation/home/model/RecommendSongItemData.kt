package org.sopt.melon.presentation.home.model

import org.sopt.melon.data.model.HomeMusic

class RecommendSongItemData(
    val imageUrl: String,
    val description: String,
)

fun HomeMusic.toRecommendSongItemData() {
    val description = when (index) {
        0 -> "내가 아끼는 최애곡 모음"
        1 -> "요즘 듣던 노래 이어듣기"
        2 -> "매일 찾아듣는 음악"
        else -> ""
    }

    RecommendSongItemData(
        imageUrl = imageUrl,
        description = description,
    )
}
