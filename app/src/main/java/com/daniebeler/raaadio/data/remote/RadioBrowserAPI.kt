package com.daniebeler.raaadio.data.remote

import com.daniebeler.raaadio.data.remote.dto.CountryDto
import com.daniebeler.raaadio.data.remote.dto.StationDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RadioBrowserAPI {

    @GET("json/stations/topvote?limit=40")
    fun getStationsByLikes(): Call<List<StationDto>>

    @GET("json/stations/bytagexact/{tag}?limit=40&order=votes")
    fun getStationsByTag(@Path("tag") tag: String): Call<List<StationDto>>

    @GET("json/stations/byuuid/{id}?limit=1")
    fun getStation(@Path("id") id: String): Call<List<StationDto>>

    @GET("json/countries?limit=40&order=name")
    fun getCountries(): Call<List<CountryDto>>
}