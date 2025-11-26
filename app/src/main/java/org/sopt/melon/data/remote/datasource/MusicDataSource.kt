package org.sopt.melon.data.remote.datasource

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.dto.MusicDto

interface MusicDataSource {
    suspend fun getCustomMusic(): BaseResponse<List<MusicDto>>

    suspend fun getPopularMusicList(): BaseResponse<List<MusicDto>>

    suspend fun getNewestMusicList(
        category: String,
    ): BaseResponse<List<MusicDto>>

    suspend fun getChartMusicList(): BaseResponse<List<MusicDto>>
}
