package com.daniebeler.raaadio.domain.repository

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.domain.model.Station
import kotlinx.coroutines.flow.Flow

interface StationRepository {

    fun getStationsByVotes(): Flow<Resource<List<Station>>>
    fun getStationsByTag(tag: String): Flow<Resource<List<Station>>>
    fun getStation(uuid: String): Flow<Resource<List<Station>>>
}