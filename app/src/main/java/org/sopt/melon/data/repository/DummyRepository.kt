package org.sopt.melon.data.repository

import org.sopt.melon.data.model.Dummy

interface DummyRepository {
    suspend fun getDummy(): Result<Dummy>
}
