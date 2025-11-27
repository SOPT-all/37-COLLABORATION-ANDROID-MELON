package org.sopt.melon.presentation.mixup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.core.designsystem.theme.defaultMelonColors
import org.sopt.melon.presentation.mixup.component.MixUpBigPlayBar
import org.sopt.melon.presentation.mixup.component.MixUpList
import org.sopt.melon.presentation.mixup.component.MixUpPlayingMusic
import org.sopt.melon.presentation.mixup.component.MixUpTopBar
import org.sopt.melon.presentation.mixup.model.MixUpMusicInfo

@Composable
fun MixUpRoute(
    navigateUp: () -> Unit,
    viewModel: MixUpViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    MixUpScreen(
        currentMixUpMusicInfo = uiState.currentMixUpMusicInfo,
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
    currentMixUpMusicInfo: MixUpMusicInfo,
    mixUpList: List<MixUpMusicInfo>,
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
    val isCurrentMusicSelected = selectedIds.contains(currentMixUpMusicInfo.id)

    Box(
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
        Column(
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier =
                Modifier
                    .padding(top = 16.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                    .statusBarsPadding(),
        ) {
            MixUpTopBar(
                onSearchClick = {},
                onChevronClick = onChevronClick,
                modifier = Modifier.fillMaxWidth(),
            )

            MixUpPlayingMusic(
                mixUpMusicInfo = currentMixUpMusicInfo,
                onAddAllClick = {},
                isAllSelected = isAllSelected,
                onAllSelectClick = onAllSelectClick,
                isCurrentMusicSelected = isCurrentMusicSelected,
                onSelectClick = { onSelectClick(currentMixUpMusicInfo.id) },
                modifier = Modifier.fillMaxWidth(),
            )

            MixUpList(
                mixUpMusicInfos = mixUpList,
                onReorder = onReorder,
                onSelectClick = onSelectClick,
                selectedMusicIds = selectedIds,
            )
        }

        MixUpBigPlayBar(
            isPlaying = false,
            onSettingClick = {},
            onBackClick = {},
            onPlayPauseClick = {},
            onFrontClick = {},
            currentSongImg = R.drawable.img_home2_56,
            modifier =
                Modifier
                    .align(Alignment.BottomCenter)
                    .background(color = defaultMelonColors.background2)
                    .navigationBarsPadding(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MixUpPreview() {
    MELONTheme {
        MixUpScreen(
            currentMixUpMusicInfo =
                MixUpMusicInfo(
                    id = 0,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = true,
                ),
            mixUpList =
                listOf(
                    MixUpMusicInfo(
                        id = 1,
                        imageUrl = "TODO()",
                        title = "1",
                        artistName = "NMIXX",
                        isPlaying = true,
                    ),
                    MixUpMusicInfo(
                        id = 2,
                        imageUrl = "TODO()",
                        title = "2",
                        artistName = "NMIXX",
                        isPlaying = false,
                    ),
                    MixUpMusicInfo(
                        id = 3,
                        imageUrl = "TODO()",
                        title = "3",
                        artistName = "NMIXX",
                        isPlaying = true,
                    ),
                    MixUpMusicInfo(
                        id = 4,
                        imageUrl = "TODO()",
                        title = "4",
                        artistName = "NMIXX",
                        isPlaying = true,
                    ),
                    MixUpMusicInfo(
                        id = 5,
                        imageUrl = "TODO()",
                        title = "5",
                        artistName = "NMIXX",
                        isPlaying = false,
                    ),
                    MixUpMusicInfo(
                        id = 6,
                        imageUrl = "TODO(0",
                        title = "6",
                        artistName = "NMIXX",
                        isPlaying = true,
                    ),
                    MixUpMusicInfo(
                        id = 7,
                        imageUrl = "TODO()",
                        title = "7",
                        artistName = "NMIXX",
                        isPlaying = false,
                    ),
                    MixUpMusicInfo(
                        id = 8,
                        imageUrl = "TODO()",
                        title = "8",
                        artistName = "NMIXX",
                        isPlaying = false,
                    ),
                    MixUpMusicInfo(
                        id = 9,
                        imageUrl = "TODO()",
                        title = "9",
                        artistName = "NMIXX",
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
