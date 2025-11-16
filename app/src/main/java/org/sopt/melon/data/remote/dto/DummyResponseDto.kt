package org.sopt.melon.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyResponseDto(
    @SerialName("dummy")
    val dummy: String,
)
