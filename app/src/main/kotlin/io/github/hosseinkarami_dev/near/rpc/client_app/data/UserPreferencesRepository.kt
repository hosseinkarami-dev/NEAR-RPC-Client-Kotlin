package io.github.hosseinkarami_dev.near.rpc.client_app.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.Network
import kotlinx.coroutines.flow.map

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class UserPreferencesRepository(context: Context) {

    private val dataStore = context.dataStore

    private object PreferencesKeys {
        val THEME_MODE = stringPreferencesKey("theme_mode")
        val DYNAMIC_COLOR = booleanPreferencesKey("dynamic_color")
        val NETWORK = stringPreferencesKey("network")
    }

    val userPreferencesFlow = dataStore.data.map {
        val themeMode = ThemeMode.valueOf(
            it[PreferencesKeys.THEME_MODE] ?: ThemeMode.SYSTEM.name
        )
        val dynamicColor = it[PreferencesKeys.DYNAMIC_COLOR] ?: true
        val network = Network.valueOf(it[PreferencesKeys.NETWORK] ?: Network.MAINNET.name)
        UserPreferences(themeMode, dynamicColor, network)
    }

    suspend fun updateThemeMode(themeMode: ThemeMode) {
        dataStore.edit {
            it[PreferencesKeys.THEME_MODE] = themeMode.name
        }
    }

    suspend fun updateDynamicColor(dynamicColor: Boolean) {
        dataStore.edit {
            it[PreferencesKeys.DYNAMIC_COLOR] = dynamicColor
        }
    }

    suspend fun updateNetwork(network: Network) {
        dataStore.edit {
            it[PreferencesKeys.NETWORK] = network.name
        }
    }
}

data class UserPreferences(val themeMode: ThemeMode, val dynamicColor: Boolean, val network: Network)
