package com.daniebeler.raaadio.ui.composables.genre

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.daniebeler.raaadio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenreComposable(
    navController: NavHostController, genre: String, viewModel: GenreViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = genre) {
        viewModel.getStations(genre)
    }

    val lazyGridState = rememberLazyGridState()

    Scaffold(contentWindowInsets = WindowInsets(0.dp), topBar = {
        TopAppBar(windowInsets = WindowInsets(0, 0, 0, 0), title = {
            Text("Genres", fontWeight = FontWeight.Bold)
        })
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            LazyColumn(modifier = Modifier.padding(horizontal = 12.dp)) {
                items(viewModel.stationsState.stations) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(94.dp)
                            .padding(vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Favicon(link = it.favicon)

                        Spacer(modifier = Modifier.width(12.dp))

                        Column {
                            Text(text = it.name ?: "", fontWeight = FontWeight.Bold)

                            Text(text = it.country, fontSize = 12.sp)
                        }
                    }

                }
            }

        }
    }
}

@Composable
fun Favicon(link: String) {
    if (link.isBlank()) {
        Image(
            painter = painterResource(id = R.drawable.stationfallback),
            contentDescription = null,
            Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
        )
    } else {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surfaceContainer)
        ) {
            AsyncImage(
                model = link,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(10.dp))
            )
        }

    }
}