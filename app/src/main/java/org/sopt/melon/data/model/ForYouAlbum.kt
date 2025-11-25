package org.sopt.melon.data.model

data class ForYouAlbum(
    val title: String,
    val imageUrl: String,
    val coverImageUrl: String,
    val musicList: List<ForYouMusic>,
)
