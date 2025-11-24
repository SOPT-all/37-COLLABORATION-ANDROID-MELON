package org.sopt.melon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlbumDto(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("imageUrl")
    val imageUrl: String,
    @SerialName("artistName")
    val artistName: String,
    @SerialName("coverImageUrl")
    val coverImageUrl: String,
    @SerialName("musicList")
    val musicList: List<MusicDto>,
)
