package org.sopt.melon.presentation.mixup.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.sopt.melon.core.designsystem.theme.MELONTheme
import org.sopt.melon.presentation.mixup.model.MixUpMusicInfo
import org.sopt.melon.presentation.mixup.utils.DraggableItem
import org.sopt.melon.presentation.mixup.utils.rememberDragDropState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MixUpList(
    mixUpMusicInfos: List<MixUpMusicInfo>,
    selectedMusicIds: Set<Int>,
    onReorder: (Int, Int) -> Unit,
    onSelectClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    val dragDropState =
        rememberDragDropState(
            lazyListState = listState,
            onSwap = onReorder,
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
                items = mixUpMusicInfos,
                key = { _, item -> item.id },
            ) { index, item ->

                DraggableItem(
                    dragDropState = dragDropState,
                    index = index,
                    modifier = Modifier.fillMaxWidth(),
                ) { isDragging ->

                    MixUpItem(
                        mixUpMusicInfo = item,
                        isPlaying = item.isPlaying,
                        isSelected = selectedMusicIds.contains(item.id),
                        onSelectClick = { onSelectClick(item.id) },
                        draggableModifier =
                            Modifier.pointerInput(Unit) {
                                detectDragGestures(
                                    onDragStart = {
                                        dragDropState.onDragStart(index)
                                    },
                                    onDrag = { change, dragAmount ->
                                        change.consume()
                                        dragDropState.onDrag(change.position - change.previousPosition)
                                    },
                                    onDragEnd = {
                                        dragDropState.onDragInterrupted()
                                    },
                                    onDragCancel = {
                                        dragDropState.onDragInterrupted()
                                    },
                                )
                            },
                        modifier = Modifier.fillMaxWidth(),
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
        mixUpMusicInfos =
            listOf(
                MixUpMusicInfo(
                    id = 0,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = true,
                ),
                MixUpMusicInfo(
                    id = 1,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = false,
                ),
                MixUpMusicInfo(
                    id = 2,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = true,
                ),
                MixUpMusicInfo(
                    id = 3,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = true,
                ),
                MixUpMusicInfo(
                    id = 4,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = false,
                ),
                MixUpMusicInfo(
                    id = 5,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = true,
                ),
                MixUpMusicInfo(
                    id = 6,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = false,
                ),
                MixUpMusicInfo(
                    id = 7,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = false,
                ),
                MixUpMusicInfo(
                    id = 8,
                    imageUrl = "TODO()",
                    title = "Blue Valentine",
                    artistName = "NMIXX",
                    isPlaying = true,
                ),
            ),
        onReorder = { i, j -> },
        onSelectClick = { i -> },
        selectedMusicIds =
            setOf(),
    )
}
