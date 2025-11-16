package org.sopt.melon.data.remote.datasource

import org.sopt.melon.data.remote.dto.DummyResponseDto

interface DummyDataSource {
    suspend fun getDummy(): DummyResponseDto
}
