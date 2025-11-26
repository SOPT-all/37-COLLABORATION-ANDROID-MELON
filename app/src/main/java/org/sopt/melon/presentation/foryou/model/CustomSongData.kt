package org.sopt.melon.presentation.foryou.model

import androidx.compose.runtime.Immutable
import org.sopt.melon.data.model.ForYouMusic

@Immutable
data class CustomSongData(
    val imgUrl: String,
    val subtitle: String,
    val title: String,
    val artistName: String,
)

fun ForYouMusic.toCustomSongData(subtitle: String) =
    CustomSongData(
        imgUrl = imageUrl,
        subtitle = subtitle,
        title = title,
        artistName = artistName,
    )
