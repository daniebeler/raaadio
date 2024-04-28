package com.daniebeler.raaadio.data.remote.dto

import com.daniebeler.raaadio.domain.model.Station
import com.google.gson.annotations.SerializedName

data class StationDto(
    @SerializedName("bitrate") val bitrate: Int,
    @SerializedName("changeuuid") val changeuuid: String,
    @SerializedName("clickcount") val clickcount: Int,
    @SerializedName("clicktimestamp") val clicktimestamp: String,
    @SerializedName("clicktimestamp_iso8601") val clicktimestampIso8601: String,
    @SerializedName("clicktrend") val clicktrend: Int,
    @SerializedName("codec") val codec: String,
    @SerializedName("country") val country: String,
    @SerializedName("countrycode") val countrycode: String,
    @SerializedName("favicon") val favicon: String,
    @SerializedName("geo_lat") val geoLat: Any,
    @SerializedName("geo_long") val geoLong: Any,
    @SerializedName("has_extended_info") val hasExtendedInfo: Boolean,
    @SerializedName("hls") val hls: Int,
    @SerializedName("homepage") val homepage: String,
    @SerializedName("iso_3166_2") val iso31662: Any,
    @SerializedName("language") val language: String,
    @SerializedName("languagecodes") val languagecodes: String,
    @SerializedName("lastchangetime") val lastchangetime: String,
    @SerializedName("lastchangetime_iso8601") val lastchangetimeIso8601: String,
    @SerializedName("lastcheckok") val lastcheckok: Int,
    @SerializedName("lastcheckoktime") val lastcheckoktime: String,
    @SerializedName("lastcheckoktime_iso8601") val lastcheckoktimeIso8601: String,
    @SerializedName("lastchecktime") val lastchecktime: String,
    @SerializedName("lastchecktime_iso8601") val lastchecktimeIso8601: String,
    @SerializedName("lastlocalchecktime") val lastlocalchecktime: String,
    @SerializedName("lastlocalchecktime_iso8601") val lastlocalchecktimeIso8601: String,
    @SerializedName("name") val name: String,
    @SerializedName("serveruuid") val serveruuid: String,
    @SerializedName("ssl_error") val sslError: Int,
    @SerializedName("state") val state: String,
    @SerializedName("stationuuid") val stationuuid: String,
    @SerializedName("tags") val tags: String,
    @SerializedName("url") val url: String,
    @SerializedName("url_resolved") val urlResolved: String,
    @SerializedName("votes") val votes: Int
) : DtoInterface<Station> {
    override fun toModel(): Station {
        return Station(
            name = name
        )
    }
}