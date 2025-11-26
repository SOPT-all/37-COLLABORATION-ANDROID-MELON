package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.R
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.model.MusicInfo
import org.sopt.melon.presentation.mixup.utils.DraggableItem
import org.sopt.melon.presentation.mixup.utils.rememberDragDropState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MixUpList(
    musicInfos: List<MusicInfo>,
    onReorder: (Int, Int) -> Unit,
    onSelectClick: (Long) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    val dragDropState = rememberDragDropState(
        lazyListState = listState,
        onSwap = onReorder
    )

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier,
    ) {
        Text(
            text = "믹스업 목록",
            style = MELONTheme.typography.body.sb_16,
            color = MELONTheme.colors.white,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )

        LazyColumn(
            state = listState,
            contentPadding = PaddingValues(vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier,
        ) {
            itemsIndexed(
                items = musicInfos,
                key = { _, item -> item.id }
            ) { index, item ->

                DraggableItem(
                    dragDropState = dragDropState,
                    index = index,
                    modifier = Modifier.fillMaxWidth()
                ) { isDragging ->

                    MixUpItem(
                        musicInfo = musicInfos[index],
                        isPlaying = musicInfos[index].isPlaying,
                        isSelected = musicInfos[index].isSelected,
                        onSelectClick = { onSelectClick(item.id) },
                        draggableModifier = Modifier.pointerInput(Unit) {
                            detectDragGestures(
                                onDragStart = {
                                    // 핸들을 잡았을 때, 해당 인덱스로 드래그 시작 알림
                                    dragDropState.onDragStart(index)
                                },
                                onDrag = { change, dragAmount ->
                                    change.consume()
                                    // 드래그 거리만큼 상태 업데이트
                                    dragDropState.onDrag(change.position - change.previousPosition)
                                },
                                onDragEnd = {
                                    dragDropState.onDragInterrupted()
                                },
                                onDragCancel = {
                                    dragDropState.onDragInterrupted()
                                }
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = if (isDragging) MELONTheme.colors.gray500 else Color.Transparent,
                                shape = RoundedCornerShape(8.dp)
                            )
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x121212)
@Composable
fun MixUpListPreview() {
    MixUpList(
        musicInfos =
            listOf(
                MusicInfo(
                    id = 0,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                    isSelected = false,
                ),
                MusicInfo(
                    id = 1,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = false,
                    isSelected = true,
                ),
                MusicInfo(
                    id = 2,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                    isSelected = true,
                ),
                MusicInfo(
                    id = 3,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                    isSelected = false,
                ),
                MusicInfo(
                    id = 4,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = false,
                    isSelected = true,
                ),
                MusicInfo(
                    id = 5,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                    isSelected = true,
                ),
                MusicInfo(
                    id = 6,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = false,
                    isSelected = true,
                ),
                MusicInfo(
                    id = 7,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = false,
                    isSelected = false,
                ),
                MusicInfo(
                    id = 8,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    singer = "NMIXX",
                    isPlaying = true,
                    isSelected = true,
                ),
            ),
        onReorder = {i, j -> },
        onSelectClick = {i -> },
        modifier = Modifier.size(width = 320.dp, height = 372.dp),
    )
}
