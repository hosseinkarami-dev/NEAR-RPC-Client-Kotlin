package io.github.hosseinkarami_dev.near.rpc.client_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.home.HomeScreen
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.request.RequestScreen
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.settings.SettingsDialog
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.theme.NearOpenApiClientTheme
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.theme.ThemeMode
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.Route
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.StringHelper.formatLabel
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.UiText
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel = koinViewModel()
            val uiState by viewModel.uiState.collectAsState()
            var showSettingsDialog by remember { mutableStateOf(false) }

            NearOpenApiClientTheme(
                darkTheme = when (uiState.themeMode) {
                    ThemeMode.LIGHT -> false
                    ThemeMode.DARK -> true
                    ThemeMode.SYSTEM -> isSystemInDarkTheme()
                },
                dynamicColor = uiState.dynamicColor,
            ) {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                val scrollBehavior =
                    TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

                if (showSettingsDialog) {
                    SettingsDialog(
                        onDismiss = { showSettingsDialog = false },
                        viewModel = viewModel
                    )
                }

                Scaffold(
                    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                    topBar = {
                        when (currentDestination?.route) {
                            Route.Home.path -> {
                                LargeTopAppBar(
                                    title = {
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Image(
                                                modifier = Modifier.height(150.dp),
                                                painter = painterResource(R.drawable.near_logo),
                                                contentDescription = "NEAR Protocol",
                                                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onSurfaceVariant)
                                            )
                                        }
                                    },
                                    actions = {
                                        IconButton(onClick = { showSettingsDialog = true }) {
                                            Icon(
                                                imageVector = Icons.Outlined.Settings,
                                                contentDescription = "Settings"
                                            )
                                        }
                                    },
                                    scrollBehavior = scrollBehavior
                                )
                            }

                            else -> {
                                if (currentDestination?.route?.startsWith(
                                        Route.Request.path.substringBefore(
                                            "/"
                                        )
                                    ) == true
                                ) {
                                    TopAppBar(
                                        title = {
                                            val titleText =
                                                navBackStackEntry?.arguments?.getString("endpointName")
                                                    ?.let { UiText.DynamicString(it) }
                                                    ?: UiText.StringResource(R.string.request)
                                            Text(text = titleText.asString().formatLabel())
                                        },
                                        navigationIcon = {
                                            IconButton(onClick = { navController.navigateUp() }) {
                                                Icon(
                                                    imageVector = Icons.Default.ArrowBack,
                                                    contentDescription = UiText.StringResource(R.string.back)
                                                        .asString()
                                                )
                                            }
                                        }
                                    )
                                }
                            }
                        }
                    }
                ) { contentPadding ->
                    AppNavHost(
                        navController = navController,
                        modifier = Modifier.padding(contentPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Route.Home.path,
        modifier = modifier
    ) {
        composable(Route.Home.path) {
            HomeScreen(navController = navController)
        }
        composable(Route.Request.path) { backStackEntry ->
            val endpointName = backStackEntry.arguments?.getString("endpointName") ?: ""
            val descriptionResId =
                backStackEntry.arguments?.getString("descriptionResId")?.toIntOrNull() ?: 0
            RequestScreen(viewModel = koinViewModel {
                parametersOf(
                    endpointName,
                    descriptionResId
                )
            })
        }
    }
}
