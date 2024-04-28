package com.daniebeler.raaadio.data.repository

import com.daniebeler.raaadio.data.common.Resource
import com.daniebeler.raaadio.data.remote.RadioBrowserAPI
import com.daniebeler.raaadio.data.remote.dto.StationDto
import com.daniebeler.raaadio.domain.model.Station
import com.daniebeler.raaadio.domain.repository.StationRepository
import com.daniebeler.raaadio.utils.NetworkCall
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class StationRepositoryImpl @Inject constructor(
    private val api: RadioBrowserAPI
) : StationRepository {

    override fun getStationsByVotes(): Flow<Resource<List<Station>>> {
        return NetworkCall<Station, StationDto>().makeCallList(
            api.getStationsByLikes()
        )
    }

    override fun getStation(uuid: String): Flow<Resource<List<Station>>> {
        return NetworkCall<Station, StationDto>().makeCallList(
            api.getStation(uuid)
        )
    }
}