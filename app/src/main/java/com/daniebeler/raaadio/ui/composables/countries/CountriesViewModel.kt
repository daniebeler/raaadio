package com.daniebeler.raaadio.ui.composables.countries

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.usecase.GetCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase
) : ViewModel() {

    var countriesState by mutableStateOf(CountriesState())
        private set

    init {
        getCountries()
    }

    private fun getCountries() {
        getCountriesUseCase().onEach { result ->
            countriesState = when (result) {
                is Resource.Success -> {
                    CountriesState(countries = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    CountriesState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    CountriesState(
                        isLoading = true, countries = emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}