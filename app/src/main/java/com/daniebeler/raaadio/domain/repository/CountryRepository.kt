package com.daniebeler.raaadio.domain.repository

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.model.Country
import com.daniebeler.raaadio.domain.model.Station
import kotlinx.coroutines.flow.Flow

interface CountryRepository {

    fun getCountries(): Flow<Resource<List<Country>>>
}