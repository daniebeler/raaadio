package com.daniebeler.raaadio.data.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String, val icon: ImageVector? = null
) {
    data object HomeScreen : Destinations(
        route = "home_screen", icon = Icons.Outlined.Home
    )

    data object CountriesScreen : Destinations(
        route = "countries_screen", icon = Icons.Outlined.Home
    )

    data object GenresScreen : Destinations(
        route = "genres_screen", icon = Icons.Outlined.Home
    )

    data object GenreScreen : Destinations(
        route = "genre_screen/{genre}", icon = Icons.Outlined.Home
    )

    data object StationScreen : Destinations(
        route = "station_screen/{uuid}", icon = Icons.Outlined.Home
    )

    data object TagScreen : Destinations(
        route = "tag_screen/{tag}", icon = Icons.Outlined.Home
    )


}