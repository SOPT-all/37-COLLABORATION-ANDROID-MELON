package org.sopt.melon.presentation.mixup.component

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.sopt.melon.R
import org.sopt.melon.core.common.component.MelonProgressBar
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

@Preview(showBackground = true)
@Composable
private fun MixUpBigPlayBarPreview() {
    var currentProgress by remember { mutableFloatStateOf(0.1f) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1500)
            currentProgress = 1f

            delay(1500)
            currentProgress = 0f
        }
    }
    var isPlaying by remember { mutableStateOf(true) }

    MixUpBigPlayBar(
        progressRatio = currentProgress,
        isPlaying = isPlaying,
        onSettingClock = {},
        onBackClick = {},
        onPlayPauseClick = { isPlaying = !isPlaying },
        onFrontClick = {},
        currentSongImg = R.drawable.img_home2_56,
        modifier = Modifier.size(width = 375.dp, height = 113.dp),
    )
}

@Preview(showBackground = true, backgroundColor = 2)
@Composable
private fun MusicControlBarPreview() {
    MusicControlBar(
        isPlaying = true,
        onBackClick = {},
        onPlayPauseClick = {},
        onFrontClick = {},
        modifier = Modifier.size(width = 200.dp, height = 64.dp),
    )
}

@Composable
fun MixUpBigPlayBar(
    progressRatio: Float,
    isPlaying: Boolean,
    onSettingClock: () -> Unit,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    @DrawableRes currentSongImg: Int,
    modifier: Modifier = Modifier,
) {
    val settingIcon = R.drawable.ic_settings

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

        Spacer(Modifier.size(6.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                imageVector = ImageVector.vectorResource(settingIcon),
                contentDescription = null,
                modifier =
                    Modifier
                        .size(24.dp)
                        .noRippleClickable(onSettingClock),
            )

            Spacer(Modifier.size(39.dp))

            MusicControlBar(
                isPlaying = isPlaying,
                onBackClick = onBackClick,
                onPlayPauseClick = onPlayPauseClick,
                onFrontClick = onFrontClick,
            )

            Spacer(Modifier.size(33.dp))

            Image(
                painter = painterResource(currentSongImg),
                contentDescription = null,
                modifier =
                    Modifier
                        .size(30.dp)
                        .clip(RoundedCornerShape(4.dp)),
            )
        }
    }
}

@Composable
fun MusicControlBar(
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val backIcon = R.drawable.ic_back_48
    val playPauseIcon =
        if (isPlaying) {
            R.drawable.ic_play_64
        } else {
            R.drawable.ic_pause_64
        }
    val frontIcon = R.drawable.ic_front_48

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
            modifier = Modifier.size(20.dp)
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
            modifier = Modifier.size(20.dp)
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
