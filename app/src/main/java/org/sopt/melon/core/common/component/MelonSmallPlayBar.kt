package org.sopt.melon.core.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

@Composable
fun MelonSmallPlayBar(
    title: String,
    artistName: String,
    progressRatio: Float,
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    onPlayMenuClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =
            modifier
                .background(color = defaultMelonColors.background2),
    ) {
        MelonProgressBar(
            progressRatio = progressRatio,
            modifier = Modifier.fillMaxWidth(),
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(
                        top = 7.dp,
                        start = 20.dp,
                        end = 8.dp,
                        bottom = 11.dp,
                    ),
        ) {
            SongInfo(
                title = title,
                artistName = artistName,
                modifier = Modifier,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier,
            ) {
                MelonMusicControlBar(
                    size = MelonMusicControlBarSize.SMALL,
                    isPlaying = isPlaying,
                    onBackClick = onBackClick,
                    onPlayPauseClick = onPlayPauseClick,
                    onFrontClick = onFrontClick,
                    modifier = Modifier,
                )

                Spacer(Modifier.size(4.dp))

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_playmenu),
                    contentDescription = null,
                    modifier =
                        Modifier
                            .size(40.dp)
                            .noRippleClickable(onPlayMenuClick),
                )
            }
        }
    }
}

@Composable
private fun SongInfo(
    title: String,
    artistName: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = title,
            style = MELONTheme.typography.body.m_14,
            color = MELONTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
        Text(
            text = artistName,
            style = MELONTheme.typography.caption.r_12,
            color = MELONTheme.colors.gray300,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
private fun MelonSmallPlayBarPreview() {
    var isPlaying by remember { mutableStateOf(true) }

    MelonSmallPlayBar(
        title = "Blue Valentine",
        artistName = "NMIXX",
        progressRatio = 0.5f,
        isPlaying = isPlaying,
        onBackClick = {},
        onPlayPauseClick = { isPlaying = !isPlaying },
        onFrontClick = {},
        onPlayMenuClick = {},
        modifier = Modifier.size(width = 360.dp, height = 60.dp),
    )
}

@Preview
@Composable
private fun SongInfoPreview() {
    SongInfo(
        title = "Blue Valentine",
        artistName = "NMIXX",
        modifier = Modifier,
    )
}
