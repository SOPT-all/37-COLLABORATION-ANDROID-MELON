package org.sopt.melon.presentation.foryou

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.presentation.foryou.model.CustomSongData
import org.sopt.melon.presentation.foryou.model.NewestAlbumData

data class ForYouUiState(
    val customSongList: ImmutableList<CustomSongData> = persistentListOf(),
    val newestAlbum: NewestAlbumData =
        NewestAlbumData(
            title = "",
            imageUrl = "",
            coverImageUrl = "",
            newestMusicList = persistentListOf(),
        ),
)
