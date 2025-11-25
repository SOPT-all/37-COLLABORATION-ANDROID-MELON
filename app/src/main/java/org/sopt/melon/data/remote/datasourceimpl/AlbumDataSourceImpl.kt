package org.sopt.melon.data.remote.datasourceimpl

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.datasource.AlbumDataSource
import org.sopt.melon.data.remote.dto.AlbumDto
import org.sopt.melon.data.remote.service.AlbumService
import javax.inject.Inject

class AlbumDataSourceImpl @Inject constructor(
    private val service: AlbumService,
) : AlbumDataSource {
    override suspend fun getAlbum(albumId: Int): BaseResponse<AlbumDto> = service.getAlbum(albumId = albumId)
}
