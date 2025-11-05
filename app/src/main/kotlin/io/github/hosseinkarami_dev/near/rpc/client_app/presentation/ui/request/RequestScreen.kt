package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.request

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ContentCopy
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import io.github.hosseinkarami_dev.near.rpc.client.RpcResponse
import io.github.hosseinkarami_dev.near.rpc.client_app.R
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.StringHelper.formatLabel
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.UiText
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RequestScreen(viewModel: RequestViewModel) {
    val parameterValues = remember { mutableStateMapOf<String, String>() }
    var isFormValid by remember { mutableStateOf(false) }

    LaunchedEffect(parameterValues.toMap()) {
        isFormValid = viewModel.parameters
            .filter { it.required }
            .all { parameterValues[it.name]?.isNotBlank() == true }
    }

    viewModel.response?.let {
        ResponseDialog(
            response = it,
            onDismiss = { viewModel.clearResponse() }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                elevation = CardDefaults.cardElevation(1.dp)
            ) {
                Text(
                    text = UiText.StringResource(viewModel.descriptionResId).asString(),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            viewModel.parameters.forEach { parameter ->
                OutlinedTextField(
                    value = parameterValues[parameter.name] ?: "",
                    onValueChange = {
                        parameterValues[parameter.name] = it
                    },
                    label = { RequiredLabel(parameter.name.formatLabel(), parameter.required) },
                    supportingText = { Text(parameter.description, fontWeight = FontWeight.Bold) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    singleLine = true,
                    maxLines = 1,
                    enabled = !viewModel.isLoading,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = when (parameter.keyboardType) {
                            KeyboardInputType.TEXT -> KeyboardType.Text
                            KeyboardInputType.NUMBER -> KeyboardType.Number
                        }
                    )
                )
            }
        }

        Button(
            onClick = {
                if (isFormValid) {
                    viewModel.sendRequest(parameterValues)
                }
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            elevation = ButtonDefaults.buttonElevation(0.dp),
            enabled = isFormValid && !viewModel.isLoading
        ) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.height(40.dp)) {
                if (viewModel.isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(24.dp),
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    Text(
                        text = UiText.StringResource(R.string.send_request).asString(),
                        modifier = Modifier.padding(vertical = 8.dp),
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun RequiredLabel(text: String, required: Boolean) {
    Text(buildAnnotatedString {
        append(text)
        if (required) {
            withStyle(style = SpanStyle(color = Color.Red)) {
                append(" *")
            }
        }
    })
}

@Composable
private fun ResponseDialog(response: RpcResponse<*>, onDismiss: () -> Unit) {
    val isSuccess = response is RpcResponse.Success
    val title = if (isSuccess) "Success" else "Error"
    val responseText = remember(response) {
        when (response) {
            is RpcResponse.Success -> response.result.toString()
            is RpcResponse.Failure -> response.error.toString()
        }
    }
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current

    val containerColor = if (isSuccess) {
        MaterialTheme.colorScheme.secondaryContainer
    } else {
        MaterialTheme.colorScheme.errorContainer
    }
    val contentColor = if (isSuccess) {
        MaterialTheme.colorScheme.onSecondaryContainer
    } else {
        MaterialTheme.colorScheme.onErrorContainer
    }
    val borderColor = if (isSuccess) {
        MaterialTheme.colorScheme.secondary
    } else {
        MaterialTheme.colorScheme.error
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(title) },
        text = {
            if(responseText != "null") {
                Column {
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = containerColor,
                            contentColor = contentColor
                        ),
                        border = BorderStroke(1.dp, borderColor),
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(max = 400.dp)
                    ) {
                        Column(Modifier.verticalScroll(rememberScrollState())) {
                            Text(
                                text = responseText,
                                modifier = Modifier.padding(16.dp),
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    TextButton(
                        onClick = {
                            clipboardManager.setText(AnnotatedString(responseText))
                            Toast.makeText(context, "Copied to clipboard", Toast.LENGTH_SHORT)
                                .show()
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                imageVector = Icons.Outlined.ContentCopy,
                                contentDescription = UiText.StringResource(R.string.copy_to_clipboard)
                                    .asString(),
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = UiText.StringResource(R.string.copy_to_clipboard).asString()
                            )
                        }
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
