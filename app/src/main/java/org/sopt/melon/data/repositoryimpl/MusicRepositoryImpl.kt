package org.sopt.melon.data.repositoryimpl

import org.sopt.melon.data.mapper.toForYouMusicModel
import org.sopt.melon.data.mapper.toHomeMusicModel
import org.sopt.melon.data.model.ForYouMusic
import org.sopt.melon.data.model.HomeMusic
import org.sopt.melon.data.remote.datasource.MusicDataSource
import org.sopt.melon.data.repository.MusicRepository
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val musicDataSource: MusicDataSource,
) : MusicRepository {
    override suspend fun getCustomMusic(): Result<List<ForYouMusic>> =
        runCatching {
            val response = musicDataSource.getCustomMusic()
            response.result.map { musicDto ->
                musicDto.toForYouMusicModel()
            }
        }

    override suspend fun getPopularMusicList(): Result<List<HomeMusic>> =
        runCatching {
            val response = musicDataSource.getPopularMusicList()
            response.result.mapIndexed { index, musicDto ->
                musicDto.toHomeMusicModel(index)
            }
        }

    override suspend fun getNewestMusicList(category: String): Result<List<HomeMusic>> =
        runCatching {
            val response = musicDataSource.getNewestMusicList(category)
            response.result.mapIndexed { index, musicDto ->
                musicDto.toHomeMusicModel(index)
            }
        }

    override suspend fun getChartMusicList(): Result<List<HomeMusic>> =
        runCatching {
            val response = musicDataSource.getChartMusicList()
            response.result.mapIndexed { index, musicDto ->
                musicDto.toHomeMusicModel(index)
            }
        }
}
