package org.sopt.melon.data.mapper

import org.sopt.melon.data.model.Dummy
import org.sopt.melon.data.remote.dto.MusicDto

// TODO: 각자 model 에 맞는 mapper 구현
fun MusicDto.toModel() =
    Dummy(
        dummy = title,
    )
