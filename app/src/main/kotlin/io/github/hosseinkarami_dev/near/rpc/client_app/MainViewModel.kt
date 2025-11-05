package io.github.hosseinkarami_dev.near.rpc.client_app

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.hosseinkarami_dev.near.rpc.client_app.data.UserPreferences
import io.github.hosseinkarami_dev.near.rpc.client_app.data.UserPreferencesRepository
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.Network
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(private val userPreferencesRepository: UserPreferencesRepository) : ViewModel() {

    val uiState = userPreferencesRepository.userPreferencesFlow.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = UserPreferences(ThemeMode.SYSTEM, true, Network.MAINNET)
    )

    fun updateThemeMode(themeMode: ThemeMode) {
        viewModelScope.launch {
            userPreferencesRepository.updateThemeMode(themeMode)
        }
    }

    fun updateDynamicColor(dynamicColor: Boolean) {
        viewModelScope.launch {
            userPreferencesRepository.updateDynamicColor(dynamicColor)
        }
    }

    fun updateNetwork(network: Network) {
        viewModelScope.launch {
            userPreferencesRepository.updateNetwork(network)
        }
    }
}
