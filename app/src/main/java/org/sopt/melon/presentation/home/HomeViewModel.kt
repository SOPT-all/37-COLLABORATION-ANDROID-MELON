package org.sopt.melon.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.melon.presentation.home.type.NewSongFilter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    fun onNewSongFilterClick(newSongFilter: NewSongFilter) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedNewSongTab = newSongFilter,
            )
        }
    }
}
