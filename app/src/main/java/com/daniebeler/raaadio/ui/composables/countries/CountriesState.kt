package com.daniebeler.raaadio.ui.composables.countries

import com.daniebeler.raaadio.domain.model.Country

data class CountriesState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = ""
)
