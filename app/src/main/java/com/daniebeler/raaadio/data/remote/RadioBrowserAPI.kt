package com.daniebeler.raaadio.data.remote

import com.daniebeler.raaadio.data.remote.dto.StationDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RadioBrowserAPI {

    @GET("json/stations/topvote?limit=3")
    fun getStationsByLikes(): Call<List<StationDto>>
}