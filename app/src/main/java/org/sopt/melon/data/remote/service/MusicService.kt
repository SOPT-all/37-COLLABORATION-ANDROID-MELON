package org.sopt.melon.data.remote.service

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.dto.MusicDto
import retrofit2.http.GET

interface MusicService {
    @GET("music/custom-recommendation")
    suspend fun getCustomMusic(): BaseResponse<List<MusicDto>>
}
