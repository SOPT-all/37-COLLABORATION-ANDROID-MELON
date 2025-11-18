package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.BannerData

@Composable
fun Banner(
    data: BannerData,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .height(95.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(data.backgroundColor),
    ) {
        Row(
            modifier = modifier,
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
                    data.headline,
                    style = MELONTheme.typography.body.m_14,
                    color = MELONTheme.colors.white,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    data.description,
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
        content,
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
private fun BannerPreview() {
    MELONTheme {
        Banner(
            data =
                BannerData(
                    image = R.drawable.ic_launcher_background,
                    category = "Melon Ticket",
                    headline = "우즈 CONCERT",
                    description = "멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기멜론티켓에서 예매하기",
                    backgroundColor = MELONTheme.colors.bar6,
                ),
        )
    }
}
