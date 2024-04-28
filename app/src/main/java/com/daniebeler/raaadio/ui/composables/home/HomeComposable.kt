package com.daniebeler.raaadio.ui.composables.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.daniebeler.raaadio.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeComposable(navController: NavHostController, viewModel: HomeViewModel = hiltViewModel()) {


    Scaffold(contentWindowInsets = WindowInsets(0.dp), topBar = {
        TopAppBar(windowInsets = WindowInsets(0, 0, 0, 0), title = {
            Text(stringResource(id = R.string.app_name), fontWeight = FontWeight.Bold)
        })
    }) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            Text(text = "fief")
        }
    }
}