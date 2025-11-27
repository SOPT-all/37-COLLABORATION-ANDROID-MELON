package org.sopt.melon.presentation.home.model

import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R

data class RecommendSongItemData(
    val image: Int,
    val description: String,
) {
    companion object {
        val dummyRecommendSongData =
            persistentListOf(
                RecommendSongItemData(
                    image = R.drawable.img_recommend1_140,
                    description = "내가 아끼는 최애곡 모음",
                ),
                RecommendSongItemData(
                    image = R.drawable.img_recommend2_140,
                    description = "요즘 듣던 노래 이어듣기",
                ),
                RecommendSongItemData(
                    image = R.drawable.img_recommend3_140,
                    description = "매일 찾아듣는 음악",
                ),
            )
    }
}
