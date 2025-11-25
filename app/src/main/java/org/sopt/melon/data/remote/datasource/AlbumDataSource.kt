package org.sopt.melon.data.remote.datasource

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.dto.AlbumDto

interface AlbumDataSource {
    suspend fun getAlbum(albumId: Int): BaseResponse<AlbumDto>
}
