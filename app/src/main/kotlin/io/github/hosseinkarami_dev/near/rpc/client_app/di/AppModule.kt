package io.github.hosseinkarami_dev.near.rpc.client_app.di

import io.github.hosseinkarami_dev.near.rpc.client_app.MainViewModel
import io.github.hosseinkarami_dev.near.rpc.client_app.data.UserPreferencesRepository
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.home.HomeViewModel
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.request.RequestViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    single { UserPreferencesRepository(androidContext()) }

    viewModel { MainViewModel(get()) }
    viewModel { HomeViewModel() }
    viewModel { params -> RequestViewModel(get(), get(), params[0], params[1]) }
}
