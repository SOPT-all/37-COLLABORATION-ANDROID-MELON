package org.sopt.melon.data.remote.datasourceimpl

import org.sopt.melon.data.remote.datasource.DummyDataSource
import org.sopt.melon.data.remote.dto.DummyResponseDto
import org.sopt.melon.data.remote.service.DummyService
import javax.inject.Inject

class DummyDataSourceImpl @Inject constructor(
    private val service: DummyService,
): DummyDataSource {
    override suspend fun getDummy(): DummyResponseDto = service.getDummy()
}
