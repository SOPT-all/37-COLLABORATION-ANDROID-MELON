package org.sopt.melon.presentation.mixup.model

data class MusicInfo(
    val id: Int,
    val imageUrl: String,
    val title: String,
    val singer: String,
    val isPlaying: Boolean = false,
)
