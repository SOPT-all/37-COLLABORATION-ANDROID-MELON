package org.sopt.melon.data.remote.service

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.dto.AlbumDto
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {
    @GET("album/{albumId}")
    suspend fun getAlbum(
        @Path("albumId") albumId: Int,
    ): BaseResponse<AlbumDto>
}
