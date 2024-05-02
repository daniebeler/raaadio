package com.daniebeler.raaadio.ui.composables.genres

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.daniebeler.raaadio.R
import com.daniebeler.raaadio.domain.usecase.GetStationsByLikesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GenresViewModel @Inject constructor(
    private val getStationsByLikesUseCase: GetStationsByLikesUseCase
) : ViewModel() {

    var genres by mutableStateOf<List<Genre>>(emptyList())
        private set

    init {
        initGenres()
    }

    private fun initGenres() {
        genres = listOf(
            Genre("Metal", R.drawable.metal, "metal"),
            Genre("Rock", R.drawable.rock, "rock"),
            Genre("Country", R.drawable.country, "country"),
            Genre("Pop", R.drawable.pop, "pop"),
            Genre("Lo Fi", R.drawable.lofi, "lofi"),
            Genre("Indie", R.drawable.indie, "indie"),
            Genre("Jazz", R.drawable.jazz, "jazz"),
            Genre("Classic", R.drawable.classic, "classic"),
            Genre("Hip Hop", R.drawable.hiphop, "hiphop"),
            Genre("Reggae", R.drawable.reggae, "reggae"),
        )
    }
}

data class Genre(
    val name: String, @DrawableRes val image: Int, val genreId: String
)