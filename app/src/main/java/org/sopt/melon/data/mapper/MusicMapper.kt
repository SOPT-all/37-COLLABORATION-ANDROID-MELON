package org.sopt.melon.data.mapper

import org.sopt.melon.data.model.ForYouMusic
import org.sopt.melon.data.model.HomeMusic
import org.sopt.melon.data.remote.dto.MusicDto
import org.sopt.melon.presentation.mixup.model.MixUpMusicInfo

fun MusicDto.toForYouMusicModel() =
    ForYouMusic(
        title = title,
        artistName = artistName,
        imageUrl = imageUrl,
    )

fun MusicDto.toMixUpMusicInfoModel() =
    MixUpMusicInfo(
        id = id,
        imageUrl = imageUrl,
        title = title,
        artistName = artistName,
        isPlaying = false,
    )
fun MusicDto.toHomeMusicModel(
    index: Int,
) = HomeMusic(
    index = index,
    title = title,
    artistName = artistName,
    imageUrl = imageUrl,
)
