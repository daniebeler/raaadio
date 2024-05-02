package com.daniebeler.raaadio.domain.usecase

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.model.Station
import com.daniebeler.raaadio.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow

class GetStationsByCountrycodeUseCase(private val stationRepository: StationRepository) {
    operator fun invoke(code: String): Flow<Resource<List<Station>>> {
        return stationRepository.getStationsByCountrycode(code)
    }
}