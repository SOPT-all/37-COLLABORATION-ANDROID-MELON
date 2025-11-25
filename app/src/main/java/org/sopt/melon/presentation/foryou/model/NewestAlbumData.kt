package org.sopt.melon.presentation.foryou.model

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import org.sopt.melon.data.model.ForYouAlbum
import org.sopt.melon.data.model.ForYouMusic

@Immutable
data class NewestAlbumData(
    val title: String,
    val imageUrl: String,
    val coverImageUrl: String,
    val newestMusicList: ImmutableList<NewestMusicItemData>,
)

@Immutable
data class NewestMusicItemData(
    val title: String,
    val artistName: String,
    val imageUrl: String,
)

fun ForYouAlbum.toNewestAlbumData() =
    NewestAlbumData(
        title = title,
        imageUrl = imageUrl,
        coverImageUrl = coverImageUrl,
        newestMusicList = musicList.map { it.toNewestMusicItemData() }.toImmutableList(),
    )

fun ForYouMusic.toNewestMusicItemData() =
    NewestMusicItemData(
        title = title,
        artistName = artistName,
        imageUrl = imageUrl,
    )
