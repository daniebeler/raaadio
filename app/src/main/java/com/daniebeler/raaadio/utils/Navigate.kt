package com.daniebeler.raaadio.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination

object Navigate {
    var currentBottomBarRoute: String? = null
    fun navigate(route: String, navController: NavController) {
        navController.navigate(route) {
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigateWithPopUp(newRoute: String, navController: NavController) {
        if (newRoute == currentBottomBarRoute) {
            navController.navigate(newRoute) {
                popUpTo(currentBottomBarRoute!!)
                launchSingleTop = true
            }
        } else {
            navController.navigate(newRoute) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        }
        currentBottomBarRoute = newRoute
    }

    fun navigateAndDeleteBackStack(route: String, navController: NavController) {
        navController.navigate(route) {
            popUpTo(0) {
                inclusive = true
            }

            launchSingleTop = true
        }
    }



    fun openUrlInBrowser(context: Context, url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        context.startActivity(intent)
    }
}