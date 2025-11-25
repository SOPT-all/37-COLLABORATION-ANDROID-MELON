package org.sopt.melon.presentation.foryou

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.sopt.melon.data.repository.AlbumRepository
import org.sopt.melon.data.repository.MusicRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ForYouViewModel @Inject constructor(
    private val musicRepository: MusicRepository,
    private val albumRepository: AlbumRepository,
) : ViewModel() {
    init {
        fetchCustomMusic()
        fetchAlbum()
    }

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

    companion object {
        private const val ALBUM_ID = 1
    }
}
