package org.sopt.melon.presentation.mixup.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import org.sopt.melon.core.common.component.MelonMusicControlBar
import org.sopt.melon.core.common.component.MelonMusicControlBarSize
import org.sopt.melon.core.common.component.MelonProgressBar
import org.sopt.melon.core.common.util.noRippleClickable
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

@Composable
fun MixUpBigPlayBar(
    progressRatio: Float,
    isPlaying: Boolean,
    onSettingClick: () -> Unit,
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
            Icon(
                imageVector = ImageVector.vectorResource(settingIcon),
                tint = Color.Unspecified,
                contentDescription = null,
                modifier =
                    Modifier
                        .size(24.dp)
                        .noRippleClickable(onSettingClick),
            )

            Spacer(Modifier.size(39.dp))

            MelonMusicControlBar(
                size = MelonMusicControlBarSize.BIG,
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
