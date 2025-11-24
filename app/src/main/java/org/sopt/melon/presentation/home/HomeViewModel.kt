package org.sopt.melon.presentation.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.melon.presentation.home.model.BannerData
import org.sopt.melon.presentation.home.model.PreferenceSongCardData
import org.sopt.melon.presentation.home.type.NewSongFilter
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getUserName()
        getBannerList()
        getPreferenceSong()
    }

    fun getUserName() {
        _uiState.update { currentState ->
            currentState.copy(
                userName = "닉네임",
            )
        }
    }

    fun getBannerList() {
        _uiState.update { currentState ->
            currentState.copy(
                bannerList = BannerData.dummyBannerData,
            )
        }
    }

    fun getPreferenceSong() {
        _uiState.update { currentState ->
            currentState.copy(
                preferenceSong = PreferenceSongCardData.dummyPreferenceSongCardData,
            )
        }
    }

    fun onNewSongFilterClick(newSongFilter: NewSongFilter) {
        _uiState.update { currentState ->
            currentState.copy(
                selectedNewSongTab = newSongFilter,
            )
        }
    }
}
