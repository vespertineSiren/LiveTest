package com.commentsold.livetest.di

import com.commentsold.livetest.data.remote.LiveTestService
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    private val okHttpClientBuilder: OkHttpClient.Builder =
        OkHttpClient.Builder()
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)


    @Provides
    @Singleton
    fun provideRetrofitBuilder(gsonConverterFactory: GsonConverterFactory): Retrofit.Builder =
        Retrofit.Builder()
            .addConverterFactory(gsonConverterFactory)
//            .baseUrl(CSConstants.BASE_URL_BETA)
//            .baseUrl(CSConstants.BASE_URL_ALPHA)
            .baseUrl("https://api.commentsoldbeta.com/api/2.0/commentsoldkit/")

    @Provides
    fun provideLiveTestService(
        retrofitBuilder: Retrofit.Builder
    ): LiveTestService =
        retrofitBuilder
            .client(okHttpClientBuilder.build())
            .build()
            .create(LiveTestService::class.java)
}
