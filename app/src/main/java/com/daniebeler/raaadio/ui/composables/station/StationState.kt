package com.daniebeler.raaadio.ui.composables.station

import com.daniebeler.raaadio.domain.model.Station

data class StationState (
    val isLoading: Boolean = false,
    val station: Station? = null,
    val error: String = ""
)