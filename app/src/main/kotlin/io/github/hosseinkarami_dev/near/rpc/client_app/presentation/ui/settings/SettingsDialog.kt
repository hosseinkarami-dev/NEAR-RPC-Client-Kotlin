package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.settings

import android.os.Build
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.hosseinkarami_dev.near.rpc.client_app.MainViewModel
import io.github.hosseinkarami_dev.near.rpc.client_app.R
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.Network
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.UiText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsDialog(onDismiss: () -> Unit, viewModel: MainViewModel) {
    val uiState by viewModel.uiState.collectAsState()

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = UiText.StringResource(R.string.settings).asString()) },
        text = {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = UiText.StringResource(R.string.network).asString(),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                Network.entries.forEach { network ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.updateNetwork(network) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.network == network,
                            onClick = { viewModel.updateNetwork(network) }
                        )
                        Text(
                            text = stringResource(id = network.stringResId),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                HorizontalDivider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                Text(
                    text = UiText.StringResource(R.string.theme).asString(),
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                )
                ThemeMode.entries.forEach { themeMode ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.updateThemeMode(themeMode) },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = uiState.themeMode == themeMode,
                            onClick = { viewModel.updateThemeMode(themeMode) }
                        )
                        Text(
                            text = themeMode.name.lowercase().replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                    HorizontalDivider(modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { viewModel.updateDynamicColor(!uiState.dynamicColor) },
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = UiText.StringResource(R.string.dynamic_color).asString(),
                            style = MaterialTheme.typography.bodyLarge
                        )
                        Switch(
                            checked = uiState.dynamicColor,
                            onCheckedChange = { viewModel.updateDynamicColor(it) }
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = UiText.StringResource(R.string.done).asString())
            }
        }
    )
}
