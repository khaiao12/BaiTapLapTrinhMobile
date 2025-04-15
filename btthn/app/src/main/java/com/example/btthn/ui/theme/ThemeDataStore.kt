package com.example.btthn.ui.theme

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

class ThemeDataStore(private val context: Context) {

    private object PreferencesKeys {
        val THEME_KEY = stringPreferencesKey("theme_key")
    }

    val theme: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[PreferencesKeys.THEME_KEY] ?: "white" // Giá trị mặc định
        }

    suspend fun saveTheme(theme: String) {
        context.dataStore.edit { preferences ->
            preferences[PreferencesKeys.THEME_KEY] = theme
        }
    }
}
