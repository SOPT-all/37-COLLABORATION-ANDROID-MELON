package org.sopt.melon.data.repository

import org.sopt.melon.data.model.ForYouMusic
import org.sopt.melon.presentation.mixup.model.MixUpMusicInfo

interface MusicRepository {
    suspend fun getCustomMusic(): Result<List<ForYouMusic>>

    suspend fun getMixUpList(): Result<List<MixUpMusicInfo>>
}
