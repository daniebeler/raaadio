package com.daniebeler.raaadio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daniebeler.raaadio.data.common.Destinations
import com.daniebeler.raaadio.ui.composables.HomeComposable
import com.daniebeler.raaadio.ui.theme.RaaadioTheme
import com.daniebeler.raaadio.utils.Navigate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RaaadioTheme {
                val navController: NavHostController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(bottomBar = {
                    BottomBar(navController = navController)
                }) { paddingValues ->
                    Box(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        NavigationGraph(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController,
        startDestination = Destinations.HomeScreen.route,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None }) {
        composable(Destinations.HomeScreen.route) {
            HomeComposable(navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        Destinations.HomeScreen
    )

    NavigationBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->

            NavigationBarItem(icon = {
                Icon(imageVector = screen.icon!!, contentDescription = "")
            }, selected = currentRoute == screen.route, onClick = {
                Navigate.navigateWithPopUp(screen.route, navController)
            })
        }
    }
}