package org.sopt.melon.data.remote.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.melon.data.remote.service.MusicService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun providesMusicService(retrofit: Retrofit): MusicService = retrofit.create(MusicService::class.java)
}
