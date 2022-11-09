package com.commentsold.livetest.di

import android.content.Context
import com.commentsold.livetest.data.local.prefs.CSSharedPreferencesFactory
import com.commentsold.livetest.data.local.prefs.PreferenceStorage
import com.commentsold.livetest.data.local.prefs.PreferenceStorageImpl
import com.commentsold.livetest.data.local.prefs.SessionManager
import com.commentsold.livetest.data.local.prefs.SessionManagerImpl
import com.commentsold.livetest.utils.extensions.dataStore
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Singleton
    @Provides
    fun provideGson(): Gson =
        GsonBuilder().create()

    @Singleton
    @Provides
    fun providePreferenceStorage(@ApplicationContext context: Context, gson: Gson):
        PreferenceStorage = PreferenceStorageImpl(context.dataStore, gson)

    @Singleton
    @Provides
    fun provideSessionManager(@ApplicationContext context: Context): SessionManager =
        SessionManagerImpl(CSSharedPreferencesFactory.sessionPreferences(context))
}
