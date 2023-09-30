package com.davecon.reelview.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import coil.size.Scale
import com.davecon.reelview.component.reelViewAppBar
import com.davecon.reelview.model.Movie
import com.davecon.reelview.model.getMovies

@OptIn(ExperimentalMaterial3Api::class, coil.annotation.ExperimentalCoilApi::class)
@Composable
fun DetailsScreen(navController: NavHostController, movieTitle: String?) {
    val movie = getMovies().filter { it.title == movieTitle }.first()
    Scaffold(
        topBar = {
            reelViewAppBar(movie.title, navController) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
            }
        }) { _ ->
        LazyColumn {
            item {
                DetailContent(movie = movie)
            }
        }
    }
}


// Runtime
// Genre

// Plot

@Composable
fun DetailContent(movie: Movie) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 64.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(560.dp)
                .padding(16.dp),
            painter = rememberImagePainter(data = movie.poster,
                builder = {
                    crossfade(true)
                    scale(Scale.FILL)
                }),
            contentDescription = "Movie Poster",
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = CardDefaults.cardColors(
                contentColor = Color.Black,
                containerColor = Color.White,
            )
        ) {

            Text(
                modifier = Modifier,
                text = movie.title,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                modifier = Modifier,
                text = movie.director.plus(" (${movie.year})"),
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                modifier = Modifier,
                text = "Rated: ${movie.rated} Metascore: ${movie.metascore}",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                modifier = Modifier,
                text = "Actors: ${movie.actors}",
                style = MaterialTheme.typography.labelLarge
            )

            Text(
                modifier = Modifier,
                text = "Genre: ${movie.genre}",
                style = MaterialTheme.typography.labelLarge
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier,
                    text = "Plot:",
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    modifier = Modifier,
                    text = "Runtime: ${movie.runtime}",
                    style = MaterialTheme.typography.labelLarge
                )
            }

            Text(
                modifier = Modifier,
                text = movie.plot,
                style = MaterialTheme.typography.bodyLarge
            )
        }

    }
}