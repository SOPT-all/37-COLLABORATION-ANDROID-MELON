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

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
fun MelonMusicControlBarPreview() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MelonMusicControlBar(
            isBig = true,
            isPlaying = true,
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            modifier = Modifier.size(width = 200.dp, height = 64.dp)
        )

        Spacer(modifier = Modifier.size(20.dp))

        MelonMusicControlBar(
            isBig = false,
            isPlaying = false,
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            modifier = Modifier.size(width = 108.dp, height = 32.dp)
        )
    }
}

@Composable
fun MelonMusicControlBar(
    isBig: Boolean,
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    fun selectBySize(big: Int, small: Int) = if (isBig) big else small

    val backIcon = selectBySize(
        big = R.drawable.ic_back_48,
        small = R.drawable.ic_back_32
    )
    val playPauseIcon =
        if (isPlaying) {
            selectBySize(
                big = R.drawable.ic_pause_64,
                small = R.drawable.ic_pause_32
            )
        } else {
            selectBySize(
                big = R.drawable.ic_play_64,
                small = R.drawable.ic_play_32
            )
        }

    val frontIcon = selectBySize(
        big = R.drawable.ic_front_48,
        small = R.drawable.ic_front_32
    )
    val interval = selectBySize(
        big = 20,
        small = 6
    )

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            imageVector = ImageVector.vectorResource(backIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = onBackClick,
                ),
        )

        Spacer(
            modifier = Modifier.size(interval.dp)
        )

        Image(
            imageVector = ImageVector.vectorResource(playPauseIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = { onPlayPauseClick(isPlaying) },
                ),
        )

        Spacer(
            modifier = Modifier.size(interval.dp)
        )

        Image(
            imageVector = ImageVector.vectorResource(frontIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = onFrontClick,
                ),
        )
    }
}
