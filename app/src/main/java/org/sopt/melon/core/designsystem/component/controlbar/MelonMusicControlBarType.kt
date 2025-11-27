package org.sopt.melon.core.designsystem.component.controlbar

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.sopt.melon.R

enum class MelonMusicControlBarType(
    val backIcon: Int,
    val playIcon: Int,
    val pauseIcon: Int,
    val frontIcon: Int,
    val interDp: Dp,
) {
    BIG(
        backIcon = R.drawable.ic_back_48,
        playIcon = R.drawable.ic_play_64,
        pauseIcon = R.drawable.ic_pause_64,
        frontIcon = R.drawable.ic_front_48,
        interDp = 20.dp,
    ),
    SMALL(
        backIcon = R.drawable.ic_back_32,
        playIcon = R.drawable.ic_play_32,
        pauseIcon = R.drawable.ic_pause_32,
        frontIcon = R.drawable.ic_front_32,
        interDp = 6.dp,
    ),
}
