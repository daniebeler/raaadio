package com.daniebeler.raaadio.ui.composables.home

import com.daniebeler.raaadio.domain.model.Station

data class StationsState(
    val isLoading: Boolean = false,
    val stations: List<Station> = emptyList(),
    val error: String = ""
)
