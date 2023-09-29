@file:OptIn(ExperimentalMaterial3Api::class)

package com.davecon.reelview.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.davecon.reelview.components.MovieRow
import com.davecon.reelview.navigation.MovieScreens
import com.davecon.reelview.navigation.ReelViewNavigation

@Composable
fun HomeScreen(navController: NavController, content: @Composable () -> Unit = {}) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.shadow(16.dp),
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.LightGray
                ),
                title = {
                    Text(
                        text = "ReelView App",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier,
                    )
                },
                windowInsets = WindowInsets.systemBars,
            )
        }
    ) { innerPadding ->
        val innerPadding = innerPadding
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "Nightmare Before Christmas",
        "Halloween Town",
        "Friday the 13th",
        "Halloween",
        "Hocus Pocus",
        "The Shining",
        "The Conjuring",
        "The Exorcist",
    ),
    navController: NavController
) {
    Column(
        modifier = Modifier.padding(top = 64.dp, bottom = 8.dp, end = 8.dp, start = 8.dp),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(movieList.size) { movie ->
                MovieRow(movieName = movieList[movie]) { movie ->
                    navController.navigate(route = MovieScreens.DETAILS.name+"/$movie")
                    Log.d("ReelView", "Movie clicked: $movie")
                }
            }
        }
    }
}