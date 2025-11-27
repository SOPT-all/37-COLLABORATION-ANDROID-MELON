package org.sopt.melon.core.designsystem.component.controlbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.core.common.util.noRippleClickable

@Composable
fun MelonMusicControlBar(
    controlBarType: MelonMusicControlBarType,
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val playPauseIcon = if (isPlaying) controlBarType.pauseIcon else controlBarType.playIcon

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(controlBarType.interDp),
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(controlBarType.backIcon),
            contentDescription = null,
            modifier = Modifier
                    .noRippleClickable(
                    onClick = onBackClick,
                ),
            tint = Color.Unspecified,
        )

        Icon(
            imageVector = ImageVector.vectorResource(playPauseIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = { onPlayPauseClick(isPlaying) },
                ),
            tint = Color.Unspecified,
        )

        Icon(
            imageVector = ImageVector.vectorResource(controlBarType.frontIcon),
            contentDescription = null,
            modifier =
                Modifier.noRippleClickable(
                    onClick = onFrontClick,
                ),
            tint = Color.Unspecified,
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
private fun MelonMusicControlBarPreview() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MelonMusicControlBar(
            controlBarType = MelonMusicControlBarType.BIG,
            isPlaying = true,
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            modifier = Modifier.size(width = 200.dp, height = 64.dp),
        )

        Spacer(modifier = Modifier.size(20.dp))

        MelonMusicControlBar(
            controlBarType = MelonMusicControlBarType.SMALL,
            isPlaying = false,
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            modifier = Modifier.size(width = 108.dp, height = 32.dp),
        )
    }
}
