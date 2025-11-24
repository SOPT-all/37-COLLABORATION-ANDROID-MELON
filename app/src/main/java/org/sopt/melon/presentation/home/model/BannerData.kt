package org.sopt.melon.presentation.home.model

import androidx.compose.ui.graphics.Color
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.Bar6
import org.sopt.melon.core.designsystem.theme.Blue

data class BannerData(
    val title: String,
    val image: Int,
    val category: String,
    val headline: String,
    val description: String,
    val backgroundColor: Color,
) {
    companion object {
        val dummyBannerData = persistentListOf(
            BannerData(
                title = "2025 WOODZ PREVIEW CONCERT",
                image = R.drawable.img_banner1_95,
                category = "Melon Ticket",
                headline = "우즈 CONCERT",
                description = "멜론티켓에서 예매하기",
                backgroundColor = Bar6
            ),
            BannerData(
                title = "데이터랩 이벤트 참여하고 선물 받자",
                image = R.drawable.img_banner2_95,
                category = "데이터랩 11월",
                headline = "우즈 CONCERT",
                description = "2025년을 빛낸 데이터",
                backgroundColor = Blue
            )
        )
    }
}
