package org.sopt.melon.presentation.foryou.type

enum class CustomSongType(
    val subtitle: String,
) {
    MY_TASTE("내 취향곡"),
    RECENT_PLAYLIST("최근들은 플리"),
    FOUND_SONG("내가 찾던 그곡"),
    ;

    companion object {
        fun fromIndex(index: Int): CustomSongType =
            when (index) {
                0 -> MY_TASTE
                1 -> RECENT_PLAYLIST
                2 -> FOUND_SONG
                else -> MY_TASTE
            }
    }
}
