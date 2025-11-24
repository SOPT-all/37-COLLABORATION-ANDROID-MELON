package org.sopt.melon.presentation.home.type

enum class NewSongFilter(
    val displayName: String,
) {
    ALL(displayName = "전체"),
    DOMESTIC(displayName = "국내"),
    OVERSEAS(displayName = "해외"),
}
