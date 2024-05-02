package com.daniebeler.raaadio.data.remote.dto


import com.daniebeler.raaadio.domain.model.Country
import com.google.gson.annotations.SerializedName

data class CountryDto(
    @SerializedName("iso_3166_1") val iso31661: String,
    @SerializedName("name") val name: String,
    @SerializedName("stationcount") val stationcount: Int
) : DtoInterface<Country> {
    override fun toModel(): Country {
        return Country(
            iso31661 = iso31661, name = name, stationcount = stationcount
        )
    }
}