package com.commentsold.livetest.utils.extensions

import android.content.Context
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import com.commentsold.livetest.data.local.prefs.PreferenceStorageImpl

val Context.dataStore by preferencesDataStore(
    name = PreferenceStorageImpl.PREFS_NAME,
    produceMigrations = { context ->
        listOf(SharedPreferencesMigration(context, PreferenceStorageImpl.PREFS_NAME))
    }
)
