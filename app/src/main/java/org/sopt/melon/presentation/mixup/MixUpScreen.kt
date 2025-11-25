package org.sopt.melon.presentation.mixup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.component.MixUpList
import org.sopt.melon.presentation.mixup.component.MixUpPlayingMusic
import org.sopt.melon.presentation.mixup.component.MixUpTopBar
import org.sopt.melon.presentation.mixup.model.MusicInfo

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
        modifier =
            modifier
                .fillMaxSize()
                .drawWithCache {
                    onDrawBehind {
                        drawRect(
                            brush = colors.gradient3,
                        )
                    }
                },
    ) {
        MixUpTopBar(
            onSearchClick = {},
            onChevronClick = {},
            modifier = Modifier.fillMaxWidth(),
        )

        MixUpPlayingMusic(
            musicInfo =
                MusicInfo(
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                    isSelected = false,
                ),
            onAddAllClick = {},
            isAllSelected = true,
            onAllSelectClick = {},
            isCurrentMusicSelected = false,
            onSelectClick = {},
            onMenuClick = {},
            modifier = Modifier.fillMaxWidth(),
        )
        MixUpList(
            musicInfos =
                listOf(
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = false,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = true,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = true,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = false,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = true,
                    ),
                    MusicInfo(
                        imageUrl = "TODO(0",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = true,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = true,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = false,
                    ),
                    MusicInfo(
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = true,
                    ),
                ),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MixUpPreview() {
    MELONTheme {
        MixUpScreen(
            modifier =
                Modifier
                    .size(width = 360.dp, height = 780.dp),
        )
    }
}
