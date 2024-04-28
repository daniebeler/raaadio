package com.daniebeler.raaadio.ui.composables.station

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StationComposable(
    navController: NavHostController,
    uuid: String,
    viewModel: StationViewModel = hiltViewModel(key = "station$uuid")
) {

    LaunchedEffect(key1 = uuid) {
        viewModel.getStation(uuid)
    }

    Scaffold(contentWindowInsets = WindowInsets(0.dp), topBar = {
        TopAppBar(windowInsets = WindowInsets(0, 0, 0, 0), title = {
            Text(text = viewModel.stationState.station?.name ?: "", fontWeight = FontWeight.Bold)
        })
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (viewModel.stationState.station != null) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    if (viewModel.stationState.station?.favicon!!.isNotBlank()) {
                        Box(modifier = Modifier.padding(vertical = 50.dp)) {
                            AsyncImage(
                                model = viewModel.stationState.station!!.favicon,
                                contentDescription = "",
                                modifier = Modifier
                                    .width(150.dp)
                                    .height(150.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            )
                        }

                    }

                    Text(text = viewModel.stationState.station!!.country ?: "")
                }
            }
        }
    }
}