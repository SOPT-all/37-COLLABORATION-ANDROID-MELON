package org.sopt.melon.data.mapper

import org.sopt.melon.data.model.ForYouAlbum
import org.sopt.melon.data.remote.dto.AlbumDto

fun AlbumDto.toForYouAlbumModel() =
    ForYouAlbum(
        title = title,
        imageUrl = imageUrl,
        coverImageUrl = coverImageUrl,
        musicList = musicList.map { it.toForYouMusicModel() },
    )
