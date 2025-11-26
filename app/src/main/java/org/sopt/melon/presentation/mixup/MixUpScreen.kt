package org.sopt.melon.presentation.mixup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.component.MixUpBigPlayBar
import org.sopt.melon.presentation.mixup.component.MixUpList
import org.sopt.melon.presentation.mixup.component.MixUpPlayingMusic
import org.sopt.melon.presentation.mixup.component.MixUpTopBar
import org.sopt.melon.presentation.mixup.model.MusicInfo

@Composable
fun MixUpRoute(
    navigateUp: () -> Unit,
    viewModel: MixUpViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MixUpScreen(
        currentMusicInfo = uiState.currentMusicInfo,
        mixUpList = uiState.mixUpList,
        selectedIds = uiState.selectedMusicIds,
        onChevronClick = navigateUp,
        onSelectClick = viewModel::updateSelectedMusicId,
        onAllSelectClick = viewModel::updateSelectedMusicAll,
        onReorder = viewModel::swapMusicOrder,
    )
}

@Composable
private fun MixUpScreen(
    currentMusicInfo: MusicInfo,
    mixUpList: List<MusicInfo>,
    selectedIds: Set<Int>,
    onChevronClick: () -> Unit,
    onSelectClick: (Int) -> Unit,
    onAllSelectClick: () -> Unit,
    onReorder: (Int, Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val colors = MELONTheme.colors

    val isAllSelected =
        mixUpList.isNotEmpty() &&
            selectedIds.containsAll(mixUpList.map { it.id })
    val isCurrentMusicSelected = selectedIds.contains(currentMusicInfo.id)

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
                }
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier =
                Modifier
                    .padding(top = 20.dp, bottom = 16.dp, start = 20.dp, end = 20.dp)
                    .systemBarsPadding(),
        ) {
            MixUpTopBar(
                onSearchClick = {},
                onChevronClick = onChevronClick,
                modifier = Modifier.fillMaxWidth(),
            )

            MixUpPlayingMusic(
                musicInfo = currentMusicInfo,
                onAddAllClick = {},
                isAllSelected = isAllSelected,
                onAllSelectClick = onAllSelectClick,
                isCurrentMusicSelected = isCurrentMusicSelected,
                onSelectClick = { onSelectClick(currentMusicInfo.id) },
                modifier = Modifier.fillMaxWidth(),
            )
            MixUpList(
                musicInfos = mixUpList,
                onReorder = onReorder,
                onSelectClick = onSelectClick,
                selectedMusicIds = selectedIds,
                modifier = Modifier.height(372.dp)
            )
        }

        Spacer(Modifier.weight(1f))

        MixUpBigPlayBar(
            progressRatio = 0.5f,
            isPlaying = true,
            onSettingClick = {},
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            currentSongImg = R.drawable.img_home2_56,
            modifier = Modifier.height(92.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MixUpPreview() {
    MELONTheme {
        MixUpScreen(
            currentMusicInfo =
                MusicInfo(
                    id = 0,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                ),
            mixUpList =
                listOf(
                    MusicInfo(
                        id = 1,
                        imageUrl = "TODO()",
                        title = "1",
                        singer = "NMIXX",
                        isPlaying = true,
                    ),
                    MusicInfo(
                        id = 2,
                        imageUrl = "TODO()",
                        title = "2",
                        singer = "NMIXX",
                        isPlaying = false,
                    ),
                    MusicInfo(
                        id = 3,
                        imageUrl = "TODO()",
                        title = "3",
                        singer = "NMIXX",
                        isPlaying = true,
                    ),
                    MusicInfo(
                        id = 4,
                        imageUrl = "TODO()",
                        title = "4",
                        singer = "NMIXX",
                        isPlaying = true,
                    ),
                    MusicInfo(
                        id = 5,
                        imageUrl = "TODO()",
                        title = "5",
                        singer = "NMIXX",
                        isPlaying = false,
                    ),
                    MusicInfo(
                        id = 6,
                        imageUrl = "TODO(0",
                        title = "6",
                        singer = "NMIXX",
                        isPlaying = true,
                    ),
                    MusicInfo(
                        id = 7,
                        imageUrl = "TODO()",
                        title = "7",
                        singer = "NMIXX",
                        isPlaying = false,
                    ),
                    MusicInfo(
                        id = 8,
                        imageUrl = "TODO()",
                        title = "8",
                        singer = "NMIXX",
                        isPlaying = false,
                    ),
                    MusicInfo(
                        id = 9,
                        imageUrl = "TODO()",
                        title = "9",
                        singer = "NMIXX",
                        isPlaying = true,
                    ),
                ),
            selectedIds = setOf(0),
            onChevronClick = {},
            onSelectClick = { i -> },
            onAllSelectClick = {},
            onReorder = { i, j -> },
        )
    }
}
