package org.sopt.melon.core.designsystem.component

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.sopt.melon.R
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

@Preview(showBackground = true)
@Composable
private fun PreviewMelonBigPlayBar() {
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

    MelonBigPlayBar(
        progressRatio = currentProgress,
        isPlaying = isPlaying,
        onSettingClock = {},
        onBackClick = {},
        onPlayPauseClick = { isPlaying = !isPlaying },
        onFrontClick = {},
        currentSongImg = R.drawable.img_home2_56,
        modifier = Modifier.size(width = 375.dp, height = 113.dp)
    )
}
@Preview(showBackground = true, backgroundColor = 2)
@Composable
private fun PreviewMusicControlBar() {
    MusicControlBar(
        isPlaying = true,
        onBackClick = {},
        onPlayPauseClick = {},
        onFrontClick = {},
        modifier = Modifier.size(width = 326.dp, height = 64.dp)
    )
}

@Composable
fun MelonBigPlayBar(
    progressRatio: Float,
    isPlaying: Boolean,
    onSettingClock: () -> Unit,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    @DrawableRes currentSongImg: Int,
    modifier: Modifier = Modifier
) {
    val settingIcon = painterResource(id = R.drawable.ic_settings)
    val currentSong = painterResource(id = currentSongImg)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .size(width = 375.dp, height = 113.dp)
            .background(color = defaultMelonColors.background2)
    ) {
        ProgressBar(progressRatio = progressRatio, modifier = Modifier.size(width = 375.dp, height = 2.dp))
        Spacer(Modifier.size(6.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.size(width = 326.dp, height = 64.dp)
        ) {
            Image(
                painter = settingIcon,
                contentDescription = "setting icon",
                modifier = Modifier.size(24.dp)
                    .noRippleClickable(onSettingClock),
            )
            Spacer(Modifier.size(39.dp))
            MusicControlBar(
                isPlaying = isPlaying,
                onBackClick = onBackClick,
                onPlayPauseClick = onPlayPauseClick,
                onFrontClick = onFrontClick,
                modifier = Modifier.size(width = 200.dp, height = 64.dp)
            )
            Spacer(Modifier.size(33.dp))
            Image(
                painter = currentSong,
                contentDescription = "Current Song Image",
                modifier = Modifier.size(30.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
        }
    }
}

@Composable
fun ProgressBar(progressRatio: Float, modifier: Modifier = Modifier) {
    val animatedProgress by animateFloatAsState(
        targetValue = progressRatio,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        label = "MusicProgress"
    )

    Box(modifier = modifier
        .height(2.dp)
        .background(color = defaultMelonColors.gray500)
        ) {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    scaleX = animatedProgress
                    transformOrigin = TransformOrigin(0f, 0.5f)
                }
                .background(color = defaultMelonColors.primary)
        )
    }
}

@Composable
fun MusicControlBar(
    isPlaying: Boolean,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    modifier: Modifier = Modifier
    ) {
    val backIcon = painterResource(id = R.drawable.ic_back_48)
    val playPauseIcon = if(isPlaying) painterResource(id = R.drawable.ic_play_64)
    else painterResource(id = R.drawable.ic_pause_64)
    val frontIcon = painterResource(id = R.drawable.ic_front_48)

    Row(modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly) {
        Image(
            painter = backIcon,
            contentDescription = "music back button",
            modifier = Modifier.noRippleClickable(
                onClick = onBackClick
            ),
        )
        Image(
            painter = playPauseIcon,
            contentDescription = "music ${if(isPlaying) "play" else "pause"} button",
            modifier = Modifier.noRippleClickable(
                onClick = { onPlayPauseClick(isPlaying) }
            )
        )
        Image(painter = frontIcon,
            contentDescription = "music front button",
            modifier = Modifier.noRippleClickable(
                onClick = onFrontClick
            ))
    }
}
