package com.commentsold.livetest.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

class SessionManagerImpl(private val sharedPreferences: SharedPreferences) : SessionManager {

    override fun saveToken(token: String?) {
        sharedPreferences.edit(commit = true) {
            putString(KEY_TOKEN, token)
        }
    }

    override fun getToken(): String? = sharedPreferences.getString(KEY_TOKEN, null)

    companion object {
        private const val KEY_TOKEN = "auth_token"
    }
}

object CSSharedPreferencesFactory {
    private const val SESSION_PREF = "auth_shared_pref"
    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)

    fun sessionPreferences(context: Context): SharedPreferences {
        return EncryptedSharedPreferences.create(
            SESSION_PREF,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }
}
