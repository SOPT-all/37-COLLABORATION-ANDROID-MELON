package org.sopt.melon.presentation.home.type

enum class NewSongFilter(
    val displayName: String,
    val serverQuery: String,
) {
    ALL(
        displayName = "전체",
        serverQuery = "",
    ),
    DOMESTIC(
        displayName = "국내",
        serverQuery = "KOR",
    ),
    OVERSEAS(
        displayName = "해외",
        serverQuery = "INT",
    ),
}
