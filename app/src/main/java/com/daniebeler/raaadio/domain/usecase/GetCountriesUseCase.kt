package com.daniebeler.raaadio.domain.usecase

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.model.Country
import com.daniebeler.raaadio.domain.repository.CountryRepository
import kotlinx.coroutines.flow.Flow

class GetCountriesUseCase(private val countryRepository: CountryRepository) {
    operator fun invoke(): Flow<Resource<List<Country>>> {
        return countryRepository.getCountries()
    }
}