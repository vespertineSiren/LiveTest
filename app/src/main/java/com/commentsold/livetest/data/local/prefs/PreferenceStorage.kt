package com.commentsold.livetest.data.local.prefs

import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
interface PreferenceStorage {

    suspend fun setGuestMode(isGuest: Boolean)
    val showGuestMode: Flow<Boolean>

    suspend fun showNotificationsPreference(show: Boolean)
    val notificationsPreferenceShown: Flow<Boolean>

    suspend fun preferToReceiveNotifications(prefer: Boolean)
    val preferToReceiveNotifications: Flow<Boolean>
}
