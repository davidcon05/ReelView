@file:OptIn(ExperimentalMaterial3Api::class)

package com.davecon.reelview.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davecon.reelview.component.MovieRow
import com.davecon.reelview.component.reelViewAppBar
import com.davecon.reelview.model.Movie
import com.davecon.reelview.navigation.MovieScreens
import com.davecon.reelview.model.getMovies as getMovies

@Composable
fun HomeScreen(navController: NavController, content: @Composable () -> Unit = {}) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            reelViewAppBar("ReelView", navController)
        }
    ) { innerPadding ->
        val innerPadding = innerPadding
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Column(
        modifier = Modifier.padding(top = 72.dp, bottom = 8.dp, end = 8.dp, start = 8.dp),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(movieList.size) { movie ->
                MovieRow(movie = movieList[movie]) { movie ->
                    navController.navigate(route = MovieScreens.DETAILS.name+"/$movie")
                    Log.d("ReelView", "Movie clicked: $movie")
                }
            }
        }
    }
}