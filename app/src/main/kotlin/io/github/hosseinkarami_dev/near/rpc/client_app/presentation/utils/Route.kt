package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils

sealed class Route(val path: String) {
    object Home : Route("home")
    object Request : Route("request/{endpointName}/{descriptionResId}") {
        fun createRoute(endpointName: String, descriptionResId: Int) = "request/$endpointName/$descriptionResId"
    }
}
