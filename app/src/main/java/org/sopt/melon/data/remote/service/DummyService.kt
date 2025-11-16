package org.sopt.melon.data.remote.service

import org.sopt.melon.data.remote.dto.DummyResponseDto
import retrofit2.http.GET

interface DummyService {
    @GET("/api/v1/dummy")
    suspend fun getDummy(): DummyResponseDto
}
