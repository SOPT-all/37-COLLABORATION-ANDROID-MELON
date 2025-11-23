package org.sopt.melon.core.common.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable

@Composable
fun MelonMusicControlBar(
    size: MelonMusicControlBarSize,
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val playPauseIcon = if (isPlaying) size.pauseIcon else size.playIcon

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(size.interval.dp),
    ) {
        Image(
            imageVector = ImageVector.vectorResource(size.backIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = onBackClick,
                ),
        )

        Image(
            imageVector = ImageVector.vectorResource(playPauseIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = { onPlayPauseClick(isPlaying) },
                ),
        )

        Image(
            imageVector = ImageVector.vectorResource(size.frontIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = onFrontClick,
                ),
        )
    }
}

enum class MelonMusicControlBarSize(
    val backIcon: Int,
    val playIcon: Int,
    val pauseIcon: Int,
    val frontIcon: Int,
    val interval: Int,
) {
    BIG(
        backIcon = R.drawable.ic_back_48,
        playIcon = R.drawable.ic_play_64,
        pauseIcon = R.drawable.ic_pause_64,
        frontIcon = R.drawable.ic_front_48,
        interval = 20,
    ),
    SMALL(
        backIcon = R.drawable.ic_back_32,
        playIcon = R.drawable.ic_play_32,
        pauseIcon = R.drawable.ic_pause_32,
        frontIcon = R.drawable.ic_front_32,
        interval = 6,
    ),
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
private fun MelonMusicControlBarPreview() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MelonMusicControlBar(
            size = MelonMusicControlBarSize.BIG,
            isPlaying = true,
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            modifier = Modifier.size(width = 200.dp, height = 64.dp),
        )

        Spacer(modifier = Modifier.size(20.dp))

        MelonMusicControlBar(
            size = MelonMusicControlBarSize.SMALL,
            isPlaying = false,
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            modifier = Modifier.size(width = 108.dp, height = 32.dp),
        )
    }
}
