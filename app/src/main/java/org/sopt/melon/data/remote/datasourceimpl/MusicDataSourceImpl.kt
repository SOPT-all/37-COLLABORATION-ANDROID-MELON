package org.sopt.melon.data.remote.datasourceimpl

import org.sopt.melon.core.network.model.BaseResponse
import org.sopt.melon.data.remote.datasource.MusicDataSource
import org.sopt.melon.data.remote.dto.MusicDto
import org.sopt.melon.data.remote.service.MusicService
import javax.inject.Inject

class MusicDataSourceImpl @Inject constructor(
    private val service: MusicService,
) : MusicDataSource {
    override suspend fun getCustomMusic(): BaseResponse<List<MusicDto>> = service.getCustomMusic()
}
