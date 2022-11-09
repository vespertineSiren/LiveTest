package com.commentsold.livetest.data.local.prefs

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.google.gson.Gson
import javax.inject.Inject
import kotlinx.coroutines.flow.map

class PreferenceStorageImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>,
    private val gson: Gson
) : PreferenceStorage {

    override suspend fun setGuestMode(isGuest: Boolean) {
        dataStore.edit {
            it[PREF_SIGNIN_SHOWN] = isGuest
        }
    }

    override val showGuestMode = dataStore.data.map {
        it[PREF_SIGNIN_SHOWN] ?: true
    }

    override suspend fun showNotificationsPreference(show: Boolean) {
        dataStore.edit {
            it[PREF_NOTIFICATIONS_SHOWN] = show
        }
    }

    override val notificationsPreferenceShown = dataStore.data.map {
        it[PREF_NOTIFICATIONS_SHOWN] ?: false
    }

    override suspend fun preferToReceiveNotifications(prefer: Boolean) {
        dataStore.edit {
            it[PREF_RECEIVE_NOTIFICATIONS] = prefer
        }
    }

    override val preferToReceiveNotifications = dataStore.data.map {
        it[PREF_RECEIVE_NOTIFICATIONS] ?: false
    }

    companion object {
        const val PREFS_NAME = "csMarketplace"
        val PREF_SIGNIN_SHOWN = booleanPreferencesKey("pref_signin_shown")
        val PREF_NOTIFICATIONS_SHOWN = booleanPreferencesKey("pref_notifications_shown")
        val PREF_RECEIVE_NOTIFICATIONS = booleanPreferencesKey("pref_receive_notifications")
    }
}
