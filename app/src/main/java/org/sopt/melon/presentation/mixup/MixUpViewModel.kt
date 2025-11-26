package org.sopt.melon.presentation.mixup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.melon.presentation.mixup.model.MusicInfo
import javax.inject.Inject

@HiltViewModel
class MixUpViewModel @Inject constructor() : ViewModel() {
    // 1. 리스트 상태 (순서 변경 가능하므로 StateFlow 관리)
    private val _uiState = MutableStateFlow(MixUpUiState())
    val uiState = _uiState.asStateFlow()

    init {
        val list = fetchMixUpList()
        _uiState.update {
            it.copy(
                mixUpList = list,
            )
        }
    }

    fun fetchMixUpList() =
        persistentListOf(
            MusicInfo(
                id = 1,
                imageUrl = "TODO()",
                title = "1",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 2,
                imageUrl = "TODO()",
                title = "2",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 3,
                imageUrl = "TODO()",
                title = "3",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 4,
                imageUrl = "TODO()",
                title = "4",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 5,
                imageUrl = "TODO()",
                title = "5",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 6,
                imageUrl = "TODO(0",
                title = "6",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 7,
                imageUrl = "TODO()",
                title = "7",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 8,
                imageUrl = "TODO()",
                title = "8",
                singer = "NMIXX",
            ),
            MusicInfo(
                id = 9,
                imageUrl = "TODO()",
                title = "9",
                singer = "NMIXX",
            ),
        )

    // 3. 순서 변경 로직 (Draggable)
    fun swapMusicOrder(
        fromIndex: Int,
        toIndex: Int,
    ) {
        val currentList = _uiState.value.mixUpList.toMutableList()
        if (fromIndex in currentList.indices && toIndex in currentList.indices) {
            val item = currentList.removeAt(fromIndex)
            currentList.add(toIndex, item)
            _uiState.value = _uiState.value.copy(mixUpList = currentList.toImmutableList())
        }
    }

    // 4. 개별 선택 토글
    fun updateSelectedMusicId(musicId: Int) {
        _uiState.update { currentState ->
            val newSelected =
                if (currentState.selectedMusicIds.contains(musicId)) {
                    currentState.selectedMusicIds - musicId
                } else {
                    currentState.selectedMusicIds + musicId
                }
            currentState.copy(
                selectedMusicIds = newSelected,
            )
        }
    }

    // 5. 전체 선택 토글
    fun updateSelectedMusicAll() {
        _uiState.update { currentState ->
            val allIds =
                _uiState.value.mixUpList
                    .map { it.id }
                    .toSet() + currentState.currentMusicInfo.id
            val newSelected =
                if (currentState.selectedMusicIds.containsAll(allIds)) {
                    emptySet()
                } else {
                    allIds
                }
            currentState.copy(
                selectedMusicIds = newSelected,
            )
        }
    }
}
