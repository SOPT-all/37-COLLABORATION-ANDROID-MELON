package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.BannerData

@Composable
fun HomeBannerList(
    bannerDataList: ImmutableList<BannerData>,
    modifier: Modifier = Modifier,
) {
    val pagerState =
        rememberPagerState(
            initialPage = 0,
            pageCount = { bannerDataList.size },
        )

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 20.dp),
        pageSpacing = 8.dp,
        beyondViewportPageCount = 1,
        pageSize = PageSize.Fixed(313.dp),
        modifier = modifier,
    ) { page ->
        BannerItem(
            data = bannerDataList[page],
        )
    }
}

@Composable
private fun BannerItem(
    data: BannerData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.width(313.dp),
    ) {
        Text(
            text = data.title,
            style = MELONTheme.typography.body.r_14,
            color = MELONTheme.colors.gray200,
        )

        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(95.dp)
                    .clip(shape = RoundedCornerShape(4.dp))
                    .background(data.backgroundColor),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = data.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.aspectRatio(1f),
            )

            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
            ) {
                BannerChip(data.category)

                Spacer(Modifier.height(4.dp))

                Text(
                    text = data.headline,
                    style = MELONTheme.typography.body.m_14,
                    color = MELONTheme.colors.white,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = data.description,
                    style = MELONTheme.typography.caption.r_12,
                    color = MELONTheme.colors.white,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Composable
private fun BannerChip(
    content: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = content,
        style = MELONTheme.typography.caption.m_10,
        color = MELONTheme.colors.white,
        textAlign = TextAlign.Center,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        modifier =
            modifier
                .width(67.dp)
                .border(
                    width = 1.dp,
                    color = MELONTheme.colors.white,
                    shape = RoundedCornerShape(999.dp),
                ),
    )
}

@Preview
@Composable
private fun BannerItemPreview() {
    MELONTheme {
        BannerItem(
            data =
                BannerData(
                    title = "2025 WOODZ PREVIEW CONCERT",
                    image = R.drawable.ic_launcher_background,
                    category = "Melon Ticket",
                    headline = "우즈 CONCERT",
                    description = "멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기",
                    backgroundColor = MELONTheme.colors.bar6,
                ),
        )
    }
}

@Preview
@Composable
private fun BannerListPreview() {
    MELONTheme {
        HomeBannerList(
            bannerDataList =
                persistentListOf(
                    BannerData(
                        title = "2025 WOODZ PREVIEW CONCERT",
                        image = R.drawable.ic_launcher_background,
                        category = "Melon Ticket",
                        headline = "우즈 CONCERT",
                        description = "멜론티켓에서 예매하기",
                        backgroundColor = MELONTheme.colors.bar6,
                    ),
                    BannerData(
                        title = "2025 WOODZ PREVIEW CONCERT",
                        image = R.drawable.ic_launcher_background,
                        category = "Melon Ticket",
                        headline = "우즈 CONCERT",
                        description = "멜론티켓에서 예매하기멜론티켓에서 예매하기",
                        backgroundColor = MELONTheme.colors.bar6,
                    ),
                    BannerData(
                        title = "2025 WOODZ PREVIEW CONCERT",
                        image = R.drawable.ic_launcher_background,
                        category = "Melon Ticket",
                        headline = "우즈 CONCERT",
                        description = "멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기",
                        backgroundColor = MELONTheme.colors.bar6,
                    ),
                ),
        )
    }
}
