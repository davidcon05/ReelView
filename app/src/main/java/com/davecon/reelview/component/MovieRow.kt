package com.davecon.reelview.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.davecon.reelview.model.Movie
import com.davecon.reelview.model.getMovies

@Preview
@OptIn(ExperimentalMaterial3Api::class, ExperimentalCoilApi::class, ExperimentalAnimationApi::class)
@Composable
fun MovieRow(movie: Movie = getMovies()[0]/*Movie*/, onItemClick: (String) -> Unit = {}) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            contentColor = Black,
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 2.dp,
            focusedElevation = 12.dp,
            hoveredElevation = 4.dp,
            draggedElevation = 4.dp,
            disabledElevation = 0.dp,
        ),
        onClick = {
            onItemClick(movie.title)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Black, RoundedCornerShape(corner = CornerSize(12.dp))),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .size(80.dp),
                shape = RectangleShape,
                color = Color.White
            ) {
                Image(
                    modifier = Modifier,
                    painter = rememberImagePainter(data = movie.poster,
                        builder = {
                            crossfade(true)
                            scale(Scale.FIT)
                        }),
                    contentDescription = "Movie Thumbnail",
                    contentScale = ContentScale.Fit
                )
            }

            Column(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier,
                    text = movie.title,
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    modifier = Modifier,
                    text = movie.director.plus(" (${movie.year})"),
                    style = MaterialTheme.typography.bodyMedium
                )

                Text(
                    modifier = Modifier,
                    text = "Metascore: ${movie.metascore}",
                    style = MaterialTheme.typography.bodyMedium
                )

                if (!expanded) {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(24.dp)
                            .clickable(
                                onClick = {
                                    expanded = !expanded
                                }
                            ),
                        tint = Color.DarkGray,
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                } else {
                    Icon(
                        modifier = Modifier
                            .align(Alignment.End)
                            .size(24.dp)
                            .clickable(
                                onClick = {
                                    expanded = !expanded
                                }
                            ),
                        tint = Color.DarkGray,
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Collapse"
                    )
                }

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(
                            modifier = Modifier,
                            text = "Plot:",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier,
                            text = movie.plot,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}