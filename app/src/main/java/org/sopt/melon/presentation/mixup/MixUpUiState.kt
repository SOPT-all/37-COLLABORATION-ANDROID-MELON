package org.sopt.melon.presentation.mixup

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.presentation.mixup.model.MusicInfo

data class MixUpUiState(
    val mixUpList: ImmutableList<MusicInfo> = persistentListOf(),
    val selectedMusicIds: Set<Int> = emptySet(),
    val currentMusicInfo: MusicInfo =
        MusicInfo(
            id = -1,
            imageUrl = "TODO()",
            title = "Blue Valentine",
            singer = "NMIXX",
            isPlaying = true,
        ),
)
