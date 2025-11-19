package org.sopt.melon.presentation.mixup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.tooling.preview.Preview
import org.sopt.melon.core.designsystem.theme.MELONTheme

@Composable
fun MixUpRoute(
    navigateUp: () -> Unit,
) {
    MixUpScreen()
}

@Composable
private fun MixUpScreen(
    modifier: Modifier = Modifier,
) {
    val colors = MELONTheme.colors
    Column(
        modifier = modifier
            .fillMaxSize()
            .drawWithCache {
                onDrawBehind {
                    drawRect(
                        brush = colors.gradient3,
                    )
                }
            },
    ) {
    }
}

@Preview(showBackground = true)
@Composable
private fun MixUpPreview() {
    MELONTheme {
        MixUpScreen()
    }
}
