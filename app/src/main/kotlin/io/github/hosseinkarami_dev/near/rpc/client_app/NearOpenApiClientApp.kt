package io.github.hosseinkarami_dev.near.rpc.client_app

import android.app.Application
import io.github.hosseinkarami_dev.near.rpc.client_app.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NearOpenApiClientApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NearOpenApiClientApp)
            modules(appModule)
        }
    }
}
