package org.sopt.melon.presentation.mixup.model

data class MixUpMusicInfo(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val artistName: String,
    val isPlaying: Boolean = false,
)
