package com.daniebeler.raaadio.ui.composables.station

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.usecase.GetStationByIdUseCase
import com.daniebeler.raaadio.ui.composables.home.StationsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StationViewModel @Inject constructor(
    private val getStationByIdUseCase: GetStationByIdUseCase
): ViewModel() {

    var stationState by mutableStateOf(StationState())
        private set


    fun getStation(id: String) {
        getStationByIdUseCase(id).onEach { result ->
            stationState = when (result) {
                is Resource.Success -> {
                    StationState(station = result.data)
                }

                is Resource.Error -> {
                    println("foof" + result.message)
                    StationState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    StationState(
                        isLoading = true, station = stationState.station
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}