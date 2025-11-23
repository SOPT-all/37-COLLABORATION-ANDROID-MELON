package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.melon.R.drawable.img_home2_56
import org.sopt.melon.R.drawable.img_mixup_24
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun ForYouCustomSongItem(
    imgUrl: String,
    subtitle: String,
    title: String,
    artistName: String,
    onMixUpClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            model = imgUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            error = painterResource(img_home2_56),
            modifier =
                Modifier
                    .size(size = 56.dp)
                    .clip(RoundedCornerShape(4.dp)),
        )

        Column(
            modifier =
                Modifier
                    .padding(
                        start = 10.dp,
                        end = 27.dp,
                    )
                    .weight(1f),
        ) {
            Text(
                text = subtitle,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
            )

            Text(
                text = title,
                style = MELONTheme.typography.body.r_14,
                color = MELONTheme.colors.white,
            )

            Text(
                text = artistName,
                style = MELONTheme.typography.caption.r_12,
                color = MELONTheme.colors.gray200,
            )
        }

        Image(
            painter = painterResource(id = img_mixup_24),
            contentDescription = null,
            modifier =
                Modifier
                    .size(36.dp)
                    .noRippleClickable(onClick = onMixUpClick),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouCustomSongItemPreview() {
    MELONTheme {
        ForYouCustomSongItem(
            imgUrl = "",
            subtitle = "내 취향곡",
            title = "Blue Valentine",
            artistName = "NMIXX",
            onMixUpClick = {},
            modifier = Modifier
                .background(MELONTheme.colors.background),
        )
    }
}
