package com.davecon.reelview.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.davecon.reelview.model.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRow(movie: Movie, onItemClick: (String) -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.Black,
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
                .border(1.dp, Color.Black, RoundedCornerShape(corner = CornerSize(12.dp))),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
        ) {
            Surface(
                modifier = Modifier
                    .padding(16.dp)
                    .size(100.dp),
                shape = RectangleShape,
                color = Color.White
            ) {
                Icon(
                    modifier = Modifier,
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Movie Thumbnail",
                )
            }
            Text(
                text = movie.title,
                modifier = Modifier,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}