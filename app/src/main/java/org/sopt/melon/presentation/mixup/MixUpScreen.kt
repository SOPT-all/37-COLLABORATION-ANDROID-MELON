package org.sopt.melon.presentation.mixup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.component.MixUpList
import org.sopt.melon.presentation.mixup.component.MixUpPlayingMusic
import org.sopt.melon.presentation.mixup.component.MixUpTopBar
import org.sopt.melon.presentation.mixup.model.MusicInfo
import kotlin.Int

@Composable
fun MixUpRoute(
    navigateUp: () -> Unit,
) {
    MixUpScreen(
        currentMusicInfo = TODO(),
        mixUpList = TODO(),
        selectedIds = TODO(),
        onChevronClick = TODO(),
        onSelectClick = TODO(),
        onAllSelectClick = TODO(),
        onReorder = TODO(),
        modifier = TODO()
    )
}

@Composable
private fun MixUpScreen(
    // Data (State)
    currentMusicInfo: MusicInfo,
    mixUpList: List<MusicInfo>,     // 순서가 변경될 수 있는 리스트
    selectedIds: Set<Long>,         // 선택된 음악들의 ID 집합 (체크박스 상태용)

    // Events (Actions)
    onChevronClick: () -> Unit,
    onSelectClick: (Long) -> Unit, // 개별 아이템 선택/해제
    onAllSelectClick: () -> Unit,  // 전체 선택/해제
    onReorder: (Int, Int) -> Unit,  // 리스트 순서 변경 (Draggable 결과 반영)

    modifier: Modifier = Modifier
) {
    val isAllSelected = mixUpList.isNotEmpty()
        && selectedIds.containsAll(mixUpList.map { it.id })
    val isCurrentMusicSelected = selectedIds.contains(currentMusicInfo.id)

    Column(
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier =
            modifier
                .fillMaxSize()
    ) {
        MixUpTopBar(
            onSearchClick = {}, // no function
            onChevronClick = onChevronClick, // ease in animation & route home
            modifier = Modifier.fillMaxWidth(),
        )

        MixUpPlayingMusic(
            musicInfo = currentMusicInfo,
            onAddAllClick = {}, // no function
            isAllSelected = isAllSelected,
            onAllSelectClick = onAllSelectClick, // select all music & check all checkbox
            isCurrentMusicSelected = isCurrentMusicSelected,
            onSelectClick = { onSelectClick(currentMusicInfo.id) }, // add selected list
            modifier = Modifier.fillMaxWidth(),
        )
        MixUpList( // draggable list
            musicInfos = mixUpList,
            onReorder = onReorder,
            onSelectClick = onSelectClick,
            modifier = Modifier.fillMaxWidth(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun MixUpPreview() {
    val colors = MELONTheme.colors
    MELONTheme {
        MixUpScreen(
            currentMusicInfo = MusicInfo(
                id = 0,
                imageUrl = "TODO()",
                title = "Blue Valentine",
                singer = "NMIXX",
                isPlaying = true,
                isSelected = false,
            ),
            mixUpList =
                listOf(
                    MusicInfo(
                        id = 1,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = false,
                    ),
                    MusicInfo(
                        id = 2,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = true,
                    ),
                    MusicInfo(
                        id = 3,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = true,
                    ),
                    MusicInfo(
                        id = 4,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = false,
                    ),
                    MusicInfo(
                        id = 5,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = true,
                    ),
                    MusicInfo(
                        id = 6,
                        imageUrl = "TODO(0",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = true,
                    ),
                    MusicInfo(
                        id = 7,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = true,
                    ),
                    MusicInfo(
                        id = 8,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = false,
                        isSelected = false,
                    ),
                    MusicInfo(
                        id = 9,
                        imageUrl = "TODO()",
                        title = "Blue Valentine",
                        singer = "NMIXX",
                        isPlaying = true,
                        isSelected = true,
                    ),
                ),
            selectedIds = setOf(0),
            onChevronClick = {},
        onSelectClick = {i -> },
        onAllSelectClick = {},
        onReorder = {i, j -> },
            modifier =
                Modifier
                    .fillMaxSize()
                    .drawWithCache {
                        onDrawBehind {
                            drawRect(
                                brush = colors.gradient3,
                            )
                        }
                    }
                    .padding(top = 50.dp, bottom = 160.dp, start = 20.dp, end = 20.dp),
        )
    }
}
