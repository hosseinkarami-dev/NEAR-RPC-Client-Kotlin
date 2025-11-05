package io.github.hosseinkarami_dev.near.rpc.client_app.presentation.ui.home

import androidx.lifecycle.ViewModel
import io.github.hosseinkarami_dev.near.rpc.client_app.R
import io.github.hosseinkarami_dev.near.rpc.client_app.presentation.utils.UiText

data class EndpointItem(val name: Int, val description: Int)

class HomeViewModel : ViewModel() {
    val endpoints = listOf(
        EndpointItem(R.string.status, R.string.status_desc),
        EndpointItem(R.string.transaction, R.string.transaction_desc),
        EndpointItem(R.string.view_account, R.string.view_account_desc),
        EndpointItem(R.string.tx_status, R.string.tx_status_desc),
        EndpointItem(R.string.health, R.string.health_desc),
        EndpointItem(R.string.network_info, R.string.network_info_desc),
        EndpointItem(R.string.block, R.string.block_desc),
        EndpointItem(R.string.block_effects, R.string.block_effects_desc),
        EndpointItem(R.string.chunk, R.string.chunk_desc),
        EndpointItem(R.string.validators, R.string.validators_desc),
        EndpointItem(R.string.gas_price, R.string.gas_price_desc),
        EndpointItem(R.string.next_light_client_block, R.string.next_light_client_block_desc),
    )
}
