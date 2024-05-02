package com.daniebeler.raaadio.ui.composables.station

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.daniebeler.raaadio.utils.Navigate

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun StationComposable(
    navController: NavHostController,
    uuid: String,
    viewModel: StationViewModel = hiltViewModel(key = "station$uuid")
) {

    LaunchedEffect(key1 = uuid) {
        viewModel.getStation(uuid)
    }

    val context = LocalContext.current

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

                    FlowRow (horizontalArrangement = Arrangement.Center) {
                        viewModel.stationState.station!!.tags.forEach {
                            Box(modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp)) {
                                TagBadge(text = it, navController = navController)
                            }
                        }
                    }

                    viewModel.stationState.station!!.homepage?.let {
                        Row(
                            Modifier.padding(top = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                text = it.substringAfter("https://").substringAfter("http://"),
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.clickable(onClick = {
                                    Navigate.openUrlInBrowser(
                                        context, it
                                    )
                                })
                            )
                        }
                    }

                    Text(text = viewModel.stationState.station!!.country, textAlign = TextAlign.Center)
                    Text(text = viewModel.stationState.station!!.state, fontSize = 12.sp, textAlign = TextAlign.Center)

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(text = viewModel.stationState.station!!.votes.toString() + " votes")
                }
            }
        }
    }
}

@Composable
private fun TagBadge(text: String, navController: NavController) {
    Box(
        Modifier
            .border(
                BorderStroke(1.dp, MaterialTheme.colorScheme.onSurfaceVariant),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 6.dp)
            .clickable {
                Navigate.navigate("tag_screen/${text}", navController)
            }
    ) {
        Text(text = text, fontSize = 9.sp, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}