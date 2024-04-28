package com.daniebeler.raaadio.ui.composables.tag

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.daniebeler.raaadio.ui.composables.home.Favicon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagComposable(
    navController: NavHostController,
    tag: String,
    viewModel: TagViewModel = hiltViewModel(key = "tag$tag")
) {

    LaunchedEffect(key1 = tag) {
        viewModel.getStations(tag)
    }

    val context = LocalContext.current

    Scaffold(contentWindowInsets = WindowInsets(0.dp), topBar = {
        TopAppBar(windowInsets = WindowInsets(0, 0, 0, 0), title = {
            Text(text = "Tag: $tag", fontWeight = FontWeight.Bold)
        })
    }) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            LazyColumn (Modifier.padding(horizontal = 12.dp)) {
                items(viewModel.stationsState.stations) {
                    Row {
                        Box(modifier = Modifier.size(100.dp)) {
                            Favicon(link = it.favicon)
                        }
                        
                        Spacer(modifier = Modifier.width(12.dp))

                        Text(text = it.name ?: "no name")
                    }
                }
            }
        }
    }
}