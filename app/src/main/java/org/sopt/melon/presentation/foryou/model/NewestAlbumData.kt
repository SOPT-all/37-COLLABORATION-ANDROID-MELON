package org.sopt.melon.presentation.foryou.model

import kotlinx.collections.immutable.ImmutableList

data class NewestAlbumData(
    val title: String,
    val imageUrl: String,
    val newestMusicList: ImmutableList<NewestMusicItemData>,
)

data class NewestMusicItemData(
    val title: String,
    val artistName: String,
    val imageUrl: String,
)
