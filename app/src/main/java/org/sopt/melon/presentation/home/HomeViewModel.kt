package org.sopt.melon.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.persistentListOf
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.melon.data.repository.MusicRepository
import org.sopt.melon.presentation.home.model.BannerData
import org.sopt.melon.presentation.home.model.PreferenceSongCardData
import org.sopt.melon.presentation.home.model.RecommendSongItemData
import org.sopt.melon.presentation.home.model.toMelonChartItemData
import org.sopt.melon.presentation.home.model.toNewSongItemData
import org.sopt.melon.presentation.home.model.toPopularSongData
import org.sopt.melon.presentation.home.type.NewSongFilter
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getUserName()
        getPreferenceSong()
        getRecommendSongList()
        fetchPopularSongList()
        getBannerList()
        fetchNewestSongList()
        fetchMelonChartSongList()
        getChipList()
    }

    fun getUserName() {
        _uiState.update { currentState ->
            currentState.copy(
                userName = "닉네임",
            )
        }
    }

    fun getChipList() =
        _uiState.update { currentState ->
            currentState.copy(
                chipContentList =
                    persistentListOf(
                        "TOP 100",
                        "HOT 100",
                        "월드뮤직",
                        "한강에서 즐기기 좋은 음악",
                    ),
            )
        }

    fun getRecommendSongList() {
        _uiState.update { currentState ->
            currentState.copy(
                recommendSongList = RecommendSongItemData.dummyRecommendSongData,
            )
        }
    }

    fun fetchPopularSongList() {
        viewModelScope.launch {
            musicRepository
                .getPopularMusicList()
                .onSuccess { result ->
                    val popularSongList =
                        result
                            .map { music ->
                                music.toPopularSongData()
                            }.toImmutableList()

                    _uiState.update { currentState ->
                        currentState.copy(
                            popularSongList = popularSongList,
                        )
                    }
                }.onFailure { e ->
                    Timber.tag("HomeViewModel").d(e.toString())
                }
        }
    }

    fun getBannerList() {
        _uiState.update { currentState ->
            currentState.copy(
                bannerList = BannerData.dummyBannerData,
            )
        }
    }

    fun fetchNewestSongList() {
        viewModelScope.launch {
            musicRepository
                .getNewestMusicList(_uiState.value.selectedNewSongTab.serverQuery)
                .onSuccess { result ->
                    val newSongList =
                        result
                            .map { music ->
                                music.toNewSongItemData()
                            }.toImmutableList()

                    _uiState.update { currentState ->
                        currentState.copy(
                            newSongData = newSongList,
                        )
                    }
                }.onFailure { e ->
                    Timber.tag("HomeViewModel").d(e.toString())
                }
        }
    }

    fun fetchMelonChartSongList() {
        viewModelScope.launch {
            musicRepository
                .getChartMusicList()
                .onSuccess { result ->
                    val melonChartList =
                        result
                            .map { music ->
                                music.toMelonChartItemData()
                            }.toImmutableList()

                    _uiState.update { currentState ->
                        currentState.copy(
                            melonChartList = melonChartList,
                        )
                    }
                }.onFailure { e ->
                    Timber.tag("HomeViewModel").d(e.toString())
                }
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
        fetchNewestSongList()
    }
}
