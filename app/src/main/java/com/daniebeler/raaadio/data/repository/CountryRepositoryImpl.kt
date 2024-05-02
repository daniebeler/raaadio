package com.daniebeler.raaadio.data.repository

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.data.remote.RadioBrowserAPI
import com.daniebeler.raaadio.data.remote.dto.CountryDto
import com.daniebeler.raaadio.domain.model.Country
import com.daniebeler.raaadio.domain.repository.CountryRepository
import com.daniebeler.raaadio.utils.NetworkCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: RadioBrowserAPI
) : CountryRepository {

    override fun getCountries(): Flow<Resource<List<Country>>> {
        return NetworkCall<Country, CountryDto>().makeCallList(
            api.getCountries()
        )
    }
}