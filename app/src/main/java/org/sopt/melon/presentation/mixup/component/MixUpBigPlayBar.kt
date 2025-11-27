package org.sopt.melon.presentation.mixup.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.sopt.melon.R
import org.sopt.melon.R.drawable.ic_settings
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.component.controlbar.MelonMusicControlBar
import org.sopt.melon.core.designsystem.component.controlbar.MelonMusicControlBarType
import org.sopt.melon.core.designsystem.component.controlbar.MelonProgressBar
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

private const val FIXED_CONTROL_BAR_RATIO = 72 / 360f

@Composable
fun MixUpBigPlayBar(
    isPlaying: Boolean,
    onSettingClick: () -> Unit,
    onBackClick: () -> Unit,
    onPlayPauseClick: (Boolean) -> Unit,
    onFrontClick: () -> Unit,
    @DrawableRes currentSongImg: Int,
    modifier: Modifier = Modifier,
    progressRatio: Float = FIXED_CONTROL_BAR_RATIO,
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
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier =
                Modifier
                    .padding(
                        top = 6.dp,
                        start = 17.dp,
                        end = 17.dp,
                        bottom = 20.dp,
                    ),
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(ic_settings),
                contentDescription = null,
                modifier =
                    Modifier
                        .size(24.dp)
                        .noRippleClickable(onSettingClick),
                tint = Color.Unspecified,
            )

            MelonMusicControlBar(
                controlBarType = MelonMusicControlBarType.BIG,
                isPlaying = isPlaying,
                onBackClick = onBackClick,
                onPlayPauseClick = onPlayPauseClick,
                onFrontClick = onFrontClick,
                modifier =
                    Modifier
                        .padding(
                            start = 39.dp,
                            end = 33.dp,
                        ),
            )

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
        onSettingClick = {},
        onBackClick = {},
        onPlayPauseClick = { isPlaying = !isPlaying },
        onFrontClick = {},
        currentSongImg = R.drawable.img_home2_56,
        modifier = Modifier.size(width = 375.dp, height = 113.dp),
    )
}
