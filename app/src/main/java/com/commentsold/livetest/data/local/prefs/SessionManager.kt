package com.commentsold.livetest.data.local.prefs

import javax.inject.Singleton

@Singleton
interface SessionManager {
    fun saveToken(token: String?)
    fun getToken(): String?
}
