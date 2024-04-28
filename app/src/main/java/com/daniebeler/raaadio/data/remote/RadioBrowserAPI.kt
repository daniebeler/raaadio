package com.daniebeler.raaadio.data.remote

import com.daniebeler.raaadio.data.remote.dto.StationDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RadioBrowserAPI {

    @GET("api/pixelfed/v2/discover/posts/trending")
    fun getTrendingPosts(@Query("range") range: String): Call<List<StationDto>>
}