package org.sopt.melon.data.remote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.melon.data.remote.datasource.AlbumDataSource
import org.sopt.melon.data.remote.datasource.MusicDataSource
import org.sopt.melon.data.remote.datasourceimpl.AlbumDataSourceImpl
import org.sopt.melon.data.remote.datasourceimpl.MusicDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsMusicDataSource(
        dataSourceImpl: MusicDataSourceImpl,
    ): MusicDataSource

    @Binds
    @Singleton
    abstract fun bindsAlbumDataSource(
        dataSourceImpl: AlbumDataSourceImpl,
    ): AlbumDataSource
}
