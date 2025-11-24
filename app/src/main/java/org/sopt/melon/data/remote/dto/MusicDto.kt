package org.sopt.melon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MusicDto(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("artistName")
    val artistName: String,
    @SerialName("playCount")
    val playCount: Int,
    @SerialName("country")
    val country: String,
    @SerialName("imageUrl")
    val imageUrl: String,
)
