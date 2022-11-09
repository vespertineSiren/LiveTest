package com.commentsold.livetest.utils.extensions

import android.content.Context
import android.view.View
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.ViewModel
import com.commentsold.livetest.R
import com.commentsold.livetest.data.local.prefs.PreferenceStorageImpl

val Context.dataStore by preferencesDataStore(
    name = PreferenceStorageImpl.PREFS_NAME,
    produceMigrations = { context ->
        listOf(SharedPreferencesMigration(context, PreferenceStorageImpl.PREFS_NAME))
    }
)

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

inline fun <reified T : ViewModel> Fragment.hiltLiveTestNavGraphViewModels() =
    hiltNavGraphViewModels<T>(R.id.mobile_navigation)
