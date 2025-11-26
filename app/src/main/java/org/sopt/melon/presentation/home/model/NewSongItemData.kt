package org.sopt.melon.presentation.home.model

import org.sopt.melon.data.model.HomeMusic

data class NewSongItemData(
    val imageUrl: String,
    val songTitle: String,
    val singer: String,
)

fun HomeMusic.toNewSongItemData(): NewSongItemData =
    NewSongItemData(
        imageUrl = imageUrl,
        songTitle = title,
        singer = artistName,
    )
