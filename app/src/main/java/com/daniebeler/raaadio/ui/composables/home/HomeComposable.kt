package com.daniebeler.raaadio.ui.composables.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.daniebeler.raaadio.R
import com.daniebeler.raaadio.utils.Navigate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComposable(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {


    Scaffold(contentWindowInsets = WindowInsets(0.dp), topBar = {
        TopAppBar(windowInsets = WindowInsets(0, 0, 0, 0), title = {
            Text(stringResource(id = R.string.app_name), fontWeight = FontWeight.Bold)
        })
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            Column {
                Text(text = "Most Liked")

                LazyRow(contentPadding = PaddingValues(horizontal = 10.dp)) {
                    items(viewModel.stationsState.stations) {
                        Column(
                            modifier = Modifier
                                .width(150.dp)
                                .padding(horizontal = 2.dp)
                        ) {
                            Favicon(link = it.favicon)

                            Text(text = it.name ?: "", modifier = Modifier.clickable {
                                Navigate.navigate("station_screen/${it.uuid}", navController)
                            })
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
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
        )
    } else {
        AsyncImage(
            model = link,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .clip(RoundedCornerShape(10.dp))
        )
    }
}