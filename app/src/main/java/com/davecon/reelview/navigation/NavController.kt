package com.davecon.reelview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.davecon.reelview.model.Movie
import com.davecon.reelview.screen.DetailsScreen
import com.davecon.reelview.screen.HomeScreen

/**
 * Navigation component consists of three things
 * 1. A NavHost
 * 2. A NavGraph
 * 3. A Nav Controller
 *
 * This is the container for the NavGraph and Nav Host. Notice how we
 * build th nav host using the controller and the screens enum. In the lambda
 * we build the nav graph.
 */
@Composable
fun ReelViewNavigation() {
    //
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HOME.name) {
        // Nav graph scope
        composable(MovieScreens.HOME.name) {
            // Back stack graph entry, we have to pass the composable for this screen
            HomeScreen(navController)
        }

        composable(
            MovieScreens.DETAILS.name + "/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ) {
            DetailsScreen(navController, it.arguments?.getString("movie") ?: "")
        }
    }
}