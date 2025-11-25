package org.sopt.melon.presentation.foryou.model

import androidx.annotation.DrawableRes
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R.drawable.img_today_36

data class ForYouRecommendationData(
    val label: String,
    val isSelected: Boolean,
    @DrawableRes val imageRes: Int? = null,
) {
    companion object {
        val dummyMyPreferenceData =
            persistentListOf(
                ForYouRecommendationData(
                    label = "감성보컬",
                    isSelected = true,
                ),
                ForYouRecommendationData(
                    label = "pH-1",
                    isSelected = true,
                    imageRes = img_today_36,
                ),
                ForYouRecommendationData(
                    label = "그루브있는비트",
                    isSelected = false,
                ),
            )

        val dummySituationData =
            persistentListOf(
                ForYouRecommendationData(
                    label = "드라이브",
                    isSelected = false,
                ),
                ForYouRecommendationData(
                    label = "집중할 때",
                    isSelected = false,
                ),
                ForYouRecommendationData(
                    label = "조용한 밤",
                    isSelected = true,
                ),
            )
    }
}
