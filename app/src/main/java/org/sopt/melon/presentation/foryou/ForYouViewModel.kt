package org.sopt.melon.presentation.foryou

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.sopt.melon.presentation.foryou.model.CustomSongData
import org.sopt.melon.presentation.foryou.model.NewestAlbumData
import org.sopt.melon.presentation.foryou.model.NewestMusicItemData
import javax.inject.Inject

@HiltViewModel
class ForYouViewModel @Inject constructor(
) : ViewModel() {

    private val _uiState = MutableStateFlow(ForYouUiState())
    val uiState = _uiState.asStateFlow()

    init {
        updateCustomSongList(fetchCustomSongList())
        updateNewestAlbum(fetchNewestAlbum())
    }

    // TODO: API 연동 예정
    fun fetchCustomSongList() =
        persistentListOf(
            CustomSongData(
                imgUrl = "",
                subtitle = "내 취향곡",
                title = "Blue Valentine",
                artistName = "NMIXX",
            ),
            CustomSongData(
                imgUrl = "",
                subtitle = "내 취향곡",
                title = "Blue Valentine",
                artistName = "NMIXX",
            ),
            CustomSongData(
                imgUrl = "",
                subtitle = "내 취향곡",
                title = "Blue Valentine",
                artistName = "NMIXX",
            ),
        )


    // TODO: API 연동 예정
    fun fetchNewestAlbum() = NewestAlbumData(
        imageUrl = "",
        title = "THERE'S A GHOST IN MY\nHOUSE.",
        newestMusicList = persistentListOf(
            NewestMusicItemData(
                title = "HOME.",
                artistName = "Armani White",
                imageUrl = "",
            ),
            NewestMusicItemData(
                title = "GHOST.",
                artistName = "Armani White",
                imageUrl = "",
            ),
            NewestMusicItemData(
                title = "CUT THE LIGHTS.(CHAMPIONSIP VERVERVERVERVER)",
                artistName = "Armani White",
                imageUrl = "",
            ),
            NewestMusicItemData(
                title = "HOME.",
                artistName = "Armani White",
                imageUrl = "",
            ),
        ),
    )

    private fun updateCustomSongList(
        customSongList: ImmutableList<CustomSongData>,
    ) = _uiState.update { it.copy(customSongList = customSongList) }

    private fun updateNewestAlbum(
        newestAlbum: NewestAlbumData,
    ) = _uiState.update { it.copy(newestAlbum = newestAlbum) }
}
