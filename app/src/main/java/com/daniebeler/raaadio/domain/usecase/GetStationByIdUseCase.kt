package com.daniebeler.raaadio.domain.usecase

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.model.Station
import com.daniebeler.raaadio.domain.repository.StationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetStationByIdUseCase(private val stationRepository: StationRepository) {

    operator fun invoke(uuid: String): Flow<Resource<Station>> = flow {
        emit(Resource.Loading())
        stationRepository.getStation(uuid).collect { result ->
            if (result is Resource.Success) {
                if (result.data?.first() != null) {
                    emit(Resource.Success(result.data.first()))
                } else {
                    emit(Resource.Error("Not found"))
                }
            } else if (result is Resource.Loading) {
                emit(Resource.Loading())
            } else {
                emit(Resource.Error(result.message ?: "Something went wrong"))
            }
        }
    }
}