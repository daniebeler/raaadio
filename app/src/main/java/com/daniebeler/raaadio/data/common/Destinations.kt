package com.daniebeler.raaadio.data.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destinations(
    val route: String, val icon: ImageVector? = null
) {
    object HomeScreen : Destinations(
        route = "home_screen", icon = Icons.Outlined.Home
    )

    object StationScreen : Destinations(
        route = "station_screen/{uuid}", icon = Icons.Outlined.Home
    )

    object TagScreen : Destinations(
        route = "tag_screen/{tag}", icon = Icons.Outlined.Home
    )


}