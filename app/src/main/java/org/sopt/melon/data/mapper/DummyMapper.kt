package org.sopt.melon.data.mapper

import org.sopt.melon.data.model.Dummy
import org.sopt.melon.data.remote.dto.DummyResponseDto

fun DummyResponseDto.toModel() =
    Dummy(
        dummy = dummy,
    )
