package org.sopt.melon.data.repository

import org.sopt.melon.data.model.ForYouAlbum

interface AlbumRepository {
    suspend fun getAlbum(albumId: Int): Result<ForYouAlbum>
}
