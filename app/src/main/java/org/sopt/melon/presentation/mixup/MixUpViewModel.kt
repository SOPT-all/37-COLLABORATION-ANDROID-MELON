package org.sopt.melon.presentation.mixup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toPersistentList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.melon.data.repository.MusicRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MixUpViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MixUpUiState())
    val uiState = _uiState.asStateFlow()

    init {
        fetchMixUpList()
    }

    fun fetchMixUpList() {
        viewModelScope.launch {
            musicRepository
                .getMixUpList()
                .onSuccess { result ->
                    _uiState.update {
                        it.copy(
                            mixUpList = result.toPersistentList(),
                        )
                    }
                }.onFailure { error ->
                    Timber.tag("MixUpViewModel").d(error.toString())
                }
        }
    }

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

    fun updateSelectedMusicAll() {
        _uiState.update { currentState ->
            val allIds =
                _uiState.value.mixUpList
                    .map { it.id }
                    .toSet() + currentState.currentMixUpMusicInfo.id
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
