package org.sopt.melon.presentation.mixup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.sopt.melon.presentation.mixup.model.MusicInfo
import javax.inject.Inject

@HiltViewModel
class MixUpViewModel @Inject constructor(): ViewModel() {

    // 1. 리스트 상태 (순서 변경 가능하므로 StateFlow 관리)
    private val _mixUpList = MutableStateFlow<List<MusicInfo>>(emptyList())
    val mixUpList: StateFlow<List<MusicInfo>> = _mixUpList.asStateFlow()

    // 2. 선택된 아이템들의 ID 관리
    private val _selectedIds = MutableStateFlow<Set<Long>>(emptySet())
    val selectedIds: StateFlow<Set<Long>> = _selectedIds.asStateFlow()

    // 3. 순서 변경 로직 (Draggable)
    fun swapMusicOrder(fromIndex: Int, toIndex: Int) {
        val currentList = _mixUpList.value.toMutableList()
        if (fromIndex in currentList.indices && toIndex in currentList.indices) {
            val item = currentList.removeAt(fromIndex)
            currentList.add(toIndex, item)
            _mixUpList.value = currentList
        }
    }

    // 4. 개별 선택 토글
    fun onSelection(musicId: Long) {
        val currentSelected = _selectedIds.value.toMutableSet()
        if (currentSelected.contains(musicId)) {
            currentSelected.remove(musicId)
        } else {
            currentSelected.add(musicId)
        }
        _selectedIds.value = currentSelected
    }

    // 5. 전체 선택 토글
    fun onSelectAll() {
        val allIds = _mixUpList.value.map { it.id }.toSet()
        val currentSelected = _selectedIds.value

        if (currentSelected.containsAll(allIds)) {
            // 이미 다 선택되어 있으면 -> 전체 해제 (혹은 currentMusicInfo만 제외 등 기획에 따름)
            _selectedIds.value = emptySet()
        } else {
            // 하나라도 선택 안 된 게 있으면 -> 전체 선택
            _selectedIds.value = allIds
        }
    }
}
