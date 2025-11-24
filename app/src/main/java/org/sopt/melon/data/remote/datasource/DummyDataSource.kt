package org.sopt.melon.data.remote.datasource

import org.sopt.melon.data.remote.dto.MusicDto

interface DummyDataSource {
    suspend fun getDummy(): MusicDto
}
