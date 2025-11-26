package org.sopt.melon.data.repositoryimpl

import org.sopt.melon.data.mapper.toForYouAlbumModel
import org.sopt.melon.data.model.ForYouAlbum
import org.sopt.melon.data.remote.datasource.AlbumDataSource
import org.sopt.melon.data.repository.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val albumDataSource: AlbumDataSource,
) : AlbumRepository {
    override suspend fun getAlbum(albumId: Int): Result<ForYouAlbum> =
        runCatching {
            val response = albumDataSource.getAlbum(albumId)
            response.result.toForYouAlbumModel()
        }
}
