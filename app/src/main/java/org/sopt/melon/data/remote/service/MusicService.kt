package org.sopt.melon.data.remote.service

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.dto.MusicDto
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {
    @GET("music/custom-recommendation")
    suspend fun getCustomMusic(): BaseResponse<List<MusicDto>>
    @GET("music/mixup")
    suspend fun getMixUpList(): BaseResponse<List<MusicDto>>
    @GET("music/popular")
    suspend fun getPopularMusicList(): BaseResponse<List<MusicDto>>
    @GET("music/newest")
    suspend fun getNewestMusicList(
        @Query("category") category: String,
    ): BaseResponse<List<MusicDto>>
    @GET("music/chart")
    suspend fun getChartMusicList(): BaseResponse<List<MusicDto>>
}
