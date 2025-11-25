package org.sopt.melon.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.melon.data.repository.MusicRepository
import org.sopt.melon.data.repositoryimpl.MusicRepositoryImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindsMusicRepository(
        musicRepositoryImpl: MusicRepositoryImpl,
    ): MusicRepository
}
