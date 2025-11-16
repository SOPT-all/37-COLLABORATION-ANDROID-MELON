package org.sopt.melon.data.remote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.melon.data.remote.datasource.DummyDataSource
import org.sopt.melon.data.remote.datasourceimpl.DummyDataSourceImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Binds
    @Singleton
    abstract fun bindsDummyDataSource(
        dummyDataSourceImpl: DummyDataSourceImpl,
    ): DummyDataSource
}
