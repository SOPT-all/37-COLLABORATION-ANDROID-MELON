package org.sopt.melon.presentation.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.home.model.PreferenceSongCardData

@Composable
fun PreferenceSongCard(
    data: PreferenceSongCardData,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))
            .background(MELONTheme.colors.gray600),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = data.image),
            contentDescription = null,
            modifier = Modifier.size(95.dp),
        )
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Text(
                data.description,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                data.songTitle,
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.white,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                data.singer,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
private fun PreferenceSongCardPreview() {
    MELONTheme {
        PreferenceSongCard(
            data = PreferenceSongCardData(
                image = R.drawable.img_preference_95,
                description = "내 취향 기반 추천곡 내 취향 기반 추천곡 내 취향 기반 추천곡 내 취향 기반 추천곡",
                songTitle = "The Day The Day",
                singer = "DAY6(데이식스)",
            ),
        )
    }
}
