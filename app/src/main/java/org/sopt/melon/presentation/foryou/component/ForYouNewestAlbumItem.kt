package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.sopt.melon.R.drawable.img_newest_album
import org.sopt.melon.R.string.foryou_newest_chip_title
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun ForYouNewestAlbumItem(
    albumUrl: String,
    title: String,
    artistName: String,
    isTitle: Boolean,
    modifier: Modifier = Modifier,
) {
    val (titleColor, artistColor) =
        if (isTitle) {
            MELONTheme.colors.primary to MELONTheme.colors.primary
        } else {
            MELONTheme.colors.white to MELONTheme.colors.opacity1
        }

    val titleTypo = if (isTitle) MELONTheme.typography.body.b_14 else MELONTheme.typography.body.r_14

    Row(
        modifier =
        modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AsyncImage(
            model = albumUrl,
            contentDescription = null,
            error = painterResource(img_newest_album),
            modifier =
                Modifier
                    .size(28.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .border(
                        width = 0.5.dp,
                        brush = MELONTheme.colors.gradientVerticalLine,
                        shape = RoundedCornerShape(4.dp),
                    ),
        )

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            if (isTitle) {
                Text(
                    text = stringResource(foryou_newest_chip_title),
                    style = MELONTheme.typography.caption.sb_8,
                    color = MELONTheme.colors.primary,
                    modifier =
                        Modifier
                            .border(
                                width = 1.dp,
                                color = MELONTheme.colors.primary,
                                shape = RoundedCornerShape(8.dp),
                            ).padding(
                                vertical = 1.dp,
                                horizontal = 3.5.dp,
                            ),
                )
            }

            Text(
                text = title,
                style = titleTypo,
                color = titleColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )

            Text(
                text = artistName,
                style = MELONTheme.typography.body.r_14,
                color = artistColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouNewestAlbumItemPreview() {
    MELONTheme {
        ForYouNewestAlbumItem(
            albumUrl = "",
            title = "HOME.",
            artistName = "Armani White",
            isTitle = true,
        )
    }
}
