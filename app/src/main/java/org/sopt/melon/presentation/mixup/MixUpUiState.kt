package org.sopt.melon.presentation.mixup

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import org.sopt.melon.presentation.mixup.model.MixUpMusicInfo

data class MixUpUiState(
    val mixUpList: ImmutableList<MixUpMusicInfo> = persistentListOf(),
    val selectedMusicIds: Set<Int> = emptySet(),
    val currentMixUpMusicInfo: MixUpMusicInfo =
        MixUpMusicInfo(
            id = -1,
            imageUrl = "TODO()",
            title = "Blue Valentine",
            artistName = "NMIXX",
            isPlaying = true,
        ),
)
