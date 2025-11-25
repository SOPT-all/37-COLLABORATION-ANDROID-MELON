package org.sopt.melon.presentation.foryou

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.sopt.melon.data.repository.AlbumRepository
import org.sopt.melon.data.repository.MusicRepository
import org.sopt.melon.presentation.foryou.model.CustomSongData
import org.sopt.melon.presentation.foryou.model.NewestAlbumData
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForYouViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
    private val albumRepository: AlbumRepository,
) : ViewModel() {
    private val _uiState = MutableStateFlow(ForYouUiState())
    val uiState = _uiState.asStateFlow()


    fun fetchCustomMusic() =
        viewModelScope.launch {
            musicRepository
                .getCustomMusic()
                .onSuccess { response ->
                    // TODO: 성공시 state update
                    Timber.tag("ForYouViewModel").d(response.toString())
                }.onFailure { e ->
                    Timber.tag("ForYouViewModel").d(e.toString())
                }
        }

    fun fetchAlbum() =
        viewModelScope.launch {
            albumRepository
                .getAlbum(ALBUM_ID)
                .onSuccess { response ->
                    // TODO: 성공시 state update
                    Timber.tag("ForYouViewModel").d(response.toString())
                }.onFailure { e ->
                    Timber.tag("ForYouViewModel").d(e.toString())
                }
        }

    private fun updateCustomSongList(
        customSongList: ImmutableList<CustomSongData>,
    ) = _uiState.update { it.copy(customSongList = customSongList) }

    private fun updateNewestAlbum(
        newestAlbum: NewestAlbumData,
    ) = _uiState.update { it.copy(newestAlbum = newestAlbum) }

    companion object {
        private const val ALBUM_ID = 1
    }
}
