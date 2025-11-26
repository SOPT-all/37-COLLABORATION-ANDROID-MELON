package org.sopt.melon.presentation.home.model

import org.sopt.melon.R

data class PreferenceSongCardData(
    val image: Int,
    val description: String,
    val songTitle: String,
    val singer: String,
) {
    companion object {
        val dummyPreferenceSongCardData =
            PreferenceSongCardData(
                image = R.drawable.img_preference_95,
                description = "내 취향 기반 추천곡",
                songTitle = "The Day",
                singer = "DAY6(데이식스)",
            )
    }
}
