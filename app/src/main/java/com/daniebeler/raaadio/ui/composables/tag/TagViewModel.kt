package com.daniebeler.raaadio.ui.composables.tag

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.usecase.GetStationsByLikesUseCase
import com.daniebeler.raaadio.domain.usecase.GetStationsByTagUseCase
import com.daniebeler.raaadio.ui.composables.home.StationsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TagViewModel @Inject constructor(
    private val getStationsByTagUseCase: GetStationsByTagUseCase
) : ViewModel() {

    var stationsState by mutableStateOf(StationsState())
        private set

    fun getStations(tag: String) {
        getStationsByTagUseCase(tag).onEach { result ->
            stationsState = when (result) {
                is Resource.Success -> {
                    StationsState(stations = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    StationsState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    StationsState(
                        isLoading = true, stations = emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}