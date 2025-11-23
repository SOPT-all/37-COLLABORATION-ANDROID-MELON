package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R.drawable.img_newest_album
import org.sopt.melon.R.drawable.img_newest_album_background
import org.sopt.melon.R.drawable.img_newest_title_album
import org.sopt.melon.R.string.foryou_newest_album_title
import org.sopt.melon.R.string.foryou_newest_chip_title
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.foryou.model.NewestAlbumData
import org.sopt.melon.presentation.foryou.model.NewestMusicItemData

@Composable
fun ForYouNewestContent(
    newestAlbum: NewestAlbumData,
    modifier: Modifier = Modifier,
) {
    val colors = MELONTheme.colors

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(foryou_newest_album_title),
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray200,
        )

        Box(
            modifier = Modifier,
        ) {
            AsyncImage(
                model = newestAlbum.imageUrl,
                contentDescription = null,
                error = painterResource(img_newest_album_background),
                contentScale = ContentScale.FillBounds,
                modifier =
                    Modifier
                        .clip(RoundedCornerShape(8.dp)),
            )

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            vertical = 18.dp,
                            horizontal = 12.dp,
                        ),
            ) {
                Text(
                    text = newestAlbum.title,
                    style = MELONTheme.typography.heading.b_20,
                    color = MELONTheme.colors.white,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )

                AsyncImage(
                    model = newestAlbum.imageUrl,
                    contentDescription = null,
                    error = painterResource(img_newest_title_album),
                    modifier =
                        Modifier
                            .padding(top = 9.dp)
                            .size(160.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .align(Alignment.CenterHorizontally),
                )
            }

            Box(
                modifier =
                    Modifier
                        .matchParentSize()
                        .drawWithCache {
                            val inset = 0.5.dp.toPx()

                            onDrawBehind {
                                drawRoundRect(
                                    brush = colors.gradient4,
                                    size =
                                        Size(
                                            width = size.width - inset * 2,
                                            height = size.height - inset * 2,
                                        ),
                                    cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx()),
                                )
                            }
                        },
            )

            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(
                            top = 226.dp,
                            start = 12.dp,
                            end = 12.dp,
                        ),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                newestAlbum.newestMusicList.forEachIndexed { idx, music ->
                    ForYouNestAlbumItem(
                        albumUrl = music.imageUrl,
                        title = music.title,
                        artistName = music.artistName,
                        isTitle = idx == 0,
                    )
                }
            }
        }
    }
}

@Composable
private fun ForYouNestAlbumItem(
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
            modifier
                .fillMaxWidth(),
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
            modifier =
                Modifier
                    .weight(1f),
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
private fun ForYouNewestCardPreview() {
    MELONTheme {
        Box(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(MELONTheme.colors.background),
            contentAlignment = Alignment.Center,
        ) {
            ForYouNewestContent(
                newestAlbum =
                    NewestAlbumData(
                        imageUrl = "",
                        title = "THERE'S A GHOST IN MY\nHOUSE.",
                        newestMusicList =
                            persistentListOf(
                                NewestMusicItemData(
                                    title = "HOME.",
                                    artistName = "Armani White",
                                    imageUrl = "",
                                ),
                                NewestMusicItemData(
                                    title = "GHOST.",
                                    artistName = "Armani White",
                                    imageUrl = "",
                                ),
                                NewestMusicItemData(
                                    title = "CUT THE LIGHTS.(CHAMPIONSIP VERVERVERVERVER)",
                                    artistName = "Armani White",
                                    imageUrl = "",
                                ),
                                NewestMusicItemData(
                                    title = "HOME.",
                                    artistName = "Armani White",
                                    imageUrl = "",
                                ),
                            ),
                    ),
                modifier =
                    Modifier
                        .padding(horizontal = 20.dp),
            )
        }
    }
}
