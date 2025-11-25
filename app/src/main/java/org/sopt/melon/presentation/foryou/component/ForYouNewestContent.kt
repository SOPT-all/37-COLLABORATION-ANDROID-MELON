package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R.drawable.img_newest_album_background
import org.sopt.melon.R.drawable.img_newest_title_album
import org.sopt.melon.R.string.foryou_newest_album_title
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.foryou.model.NewestAlbumData
import org.sopt.melon.presentation.foryou.model.NewestMusicItemData

@Composable
fun ForYouNewestContent(
    newestAlbum: NewestAlbumData,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(foryou_newest_album_title),
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray200,
        )

        Box {
            AsyncImage(
                model = newestAlbum.imageUrl,
                contentDescription = null,
                error = painterResource(img_newest_album_background),
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp)),
            )

            Box(
                modifier =
                    Modifier
                        .padding(
                            vertical = 18.dp,
                            horizontal = 12.dp,
                        ),
            ) {
                Column(
                    modifier =
                        Modifier
                            .fillMaxWidth(),
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

                GradientBox(
                    modifier =
                        Modifier
                            .matchParentSize(),
                )

                Column(
                    modifier =
                        Modifier
                            .padding(
                                top = 208.dp,
                            ),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    newestAlbum.newestMusicList.forEachIndexed { idx, music ->
                        ForYouNewestAlbumItem(
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
}

@Composable
private fun GradientBox(
    modifier: Modifier = Modifier,
) {
    val colors = MELONTheme.colors
    Box(
        modifier =
            modifier
                .drawWithCache {
                    val inset = 0.5.dp.toPx()
                    val radius = 8.dp.toPx()

                    onDrawBehind {
                        drawRoundRect(
                            brush = colors.gradient4,
                            size =
                                Size(
                                    width = size.width - inset * 2,
                                    height = size.height - inset * 2,
                                ),
                            cornerRadius = CornerRadius(radius, radius),
                        )
                    }
                },
    )
}

@Preview(showBackground = true)
@Composable
private fun ForYouNewestCardPreview() {
    MELONTheme {
        Box(
            modifier =
                Modifier
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
            )
        }
    }
}
