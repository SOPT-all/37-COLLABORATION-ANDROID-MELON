package org.sopt.melon.data.mapper

import org.sopt.melon.data.model.ForYouMusic
import org.sopt.melon.data.remote.dto.MusicDto

fun MusicDto.toForYouMusicModel() =
    ForYouMusic(
        title = title,
        artistName = artistName,
        imageUrl = imageUrl,
    )
