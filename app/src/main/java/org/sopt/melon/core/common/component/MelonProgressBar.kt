package org.sopt.melon.core.common.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import org.sopt.melon.core.designsystem.theme.defaultMelonColors

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
private fun MelonProgressBarPreview() {
    var currentProgress = 0f

    LaunchedEffect(Unit) {
        while (true) {
            delay(1500)
            currentProgress = 1f

            delay(1500)
            currentProgress = 0f
        }
    }

    MelonProgressBar(
        progressRatio = currentProgress,
        modifier = Modifier.fillMaxWidth(),
    )
}

@Composable
fun MelonProgressBar(
    progressRatio: Float,
    modifier: Modifier = Modifier,
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progressRatio,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing),
        label = "MusicProgress",
    )

    Box(
        modifier =
            modifier
                .height(2.dp)
                .background(color = defaultMelonColors.gray500),
    ) {
        Box(
            modifier =
                Modifier
                    .matchParentSize()
                    .graphicsLayer {
                        scaleX = animatedProgress
                        transformOrigin = TransformOrigin(0f, 0.5f)
                    }.background(color = defaultMelonColors.primary),
        )
    }
}
