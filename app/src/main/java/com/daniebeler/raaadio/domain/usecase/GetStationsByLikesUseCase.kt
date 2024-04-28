package com.daniebeler.raaadio.domain.usecase

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.model.Station
import com.daniebeler.raaadio.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow

class GetStationsByLikesUseCase(private val stationRepository: StationRepository) {
    operator fun invoke(): Flow<Resource<List<Station>>> {
        return stationRepository.getStationsByVotes()
    }
}