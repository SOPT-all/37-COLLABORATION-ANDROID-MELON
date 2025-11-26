package org.sopt.melon.presentation.mixup.model

data class MusicInfo(
    val id: Long,
    val imageUrl: String,
    val title: String,
    val singer: String,
    val isPlaying: Boolean,
    val isSelected: Boolean,
)
