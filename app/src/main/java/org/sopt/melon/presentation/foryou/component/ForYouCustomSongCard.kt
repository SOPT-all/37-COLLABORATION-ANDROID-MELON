package org.sopt.melon.presentation.foryou.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.R.string.foryou_custom_song_title
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.foryou.model.CustomSongData

@Composable
fun ForYouCustomSongCard(
    onMixUpClick: () -> Unit,
    customSongList: ImmutableList<CustomSongData>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MELONTheme.colors.blue,
                shape = RoundedCornerShape(8.dp),
            )
            .padding(
                top = 15.dp,
                start = 13.dp,
                end = 13.dp,
                bottom = 12.5.dp,
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(
                    bottom = 20.5.dp,
                )
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = stringResource(foryou_custom_song_title),
                style = MELONTheme.typography.heading.b_20,
                color = MELONTheme.colors.white,
            )

            ForYouIndicator()
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            customSongList.take(3).forEach { song ->
                ForYouCustomSongItem(
                    imgUrl = song.imgUrl,
                    subtitle = song.subtitle,
                    title = song.title,
                    artistName = song.artistName,
                    onMixUpClick = onMixUpClick,
                )
            }
        }
    }
}

@Composable
private fun ForYouIndicator(
    modifier: Modifier = Modifier,
) {
    val selectedList = persistentListOf(
        true,
        false,
        false,
        false,
        false,
    )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement
            .spacedBy(
                space = 5.dp,
                alignment = Alignment.CenterHorizontally,
            ),
    ) {
        selectedList.forEach { selected ->
            Box(
                modifier = Modifier
                    .size(5.dp)
                    .background(
                        color = if (selected) MELONTheme.colors.white
                        else MELONTheme.colors.opacity1,
                        shape = CircleShape,
                    ),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ForYouCustomSongCardPreview() {
    MELONTheme {
        ForYouCustomSongCard(
            onMixUpClick = {},
            customSongList = persistentListOf(
                CustomSongData(
                    imgUrl = "",
                    subtitle = "내 취향곡",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                ),
                CustomSongData(
                    imgUrl = "",
                    subtitle = "내 취향곡",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                ),
                CustomSongData(
                    imgUrl = "",
                    subtitle = "내 취향곡",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                ),
            ),
        )
    }
}
