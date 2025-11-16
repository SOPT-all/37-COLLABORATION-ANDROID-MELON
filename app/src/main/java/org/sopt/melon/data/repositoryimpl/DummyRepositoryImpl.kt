package org.sopt.melon.data.repositoryimpl

import org.sopt.melon.data.mapper.toModel
import org.sopt.melon.data.model.Dummy
import org.sopt.melon.data.remote.datasource.DummyDataSource
import org.sopt.melon.data.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl @Inject constructor(
    private val dummyDataSource: DummyDataSource,
) : DummyRepository {
    override suspend fun getDummy(): Result<Dummy> =
        runCatching {
            val response = dummyDataSource.getDummy()
            response.toModel()
        }
}
