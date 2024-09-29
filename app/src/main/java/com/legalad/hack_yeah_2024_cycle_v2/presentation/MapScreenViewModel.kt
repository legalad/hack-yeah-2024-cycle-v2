package com.legalad.hack_yeah_2024_cycle_v2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.legalad.hack_yeah_2024_cycle_v2.data.Layer
import com.legalad.hack_yeah_2024_cycle_v2.data.layersData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class MapScreenViewModel : ViewModel() {
    private val state: MutableStateFlow<State> = MutableStateFlow(State())
    val viewState: StateFlow<ViewState> = state.map { it.toViewState() }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(500L),
        initialValue = State().toViewState()
    )

    fun onToggleClicked(id: Int, value: Boolean) {
        state.update { previousState ->
            previousState.copy(
                layers = previousState.layers.mapIndexed { index, layer ->
                    if (index == id) layer.copy(isVisible = value) else layer
                }
            )
        }
    }

    private data class State(
        val layers: List<Layer> = layersData
    )

    data class ViewState(
        val layers: List<Layer>
    )

    private fun State.toViewState(): ViewState =
        ViewState(
            layers = layers
        )

}