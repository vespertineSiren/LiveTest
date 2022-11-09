package com.commentsold.livetest.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

//    @Binds
//    fun csMarketplaceRepository(repository: CSMarketplaceRemoteRepository): CSMarketplaceRepository
}
