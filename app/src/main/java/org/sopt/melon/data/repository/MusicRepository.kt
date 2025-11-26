package org.sopt.melon.data.repository

import org.sopt.melon.data.model.ForYouMusic

interface MusicRepository {
    suspend fun getCustomMusic(): Result<List<ForYouMusic>>
}
