package com.davecon.reelview

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.davecon.reelview.ui.theme.ReelViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReelViewApp {
                MainContent()
            }
        }
    }
}

/**
 * Container function great for testing and previewing
 * Also serves as an entry point for the app, useful
 * for DI and other things.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReelViewApp(content: @Composable () -> Unit) {
    ReelViewTheme {
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
                    windowInsets = WindowInsets.Companion.systemBars,
                )
            }
        ) { innerPadding ->
            val innerPadding = innerPadding
            content()
        }
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
    ),
) {
    Column(
        modifier = Modifier,
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(movieList.size) { movie ->
                MovieRow(movieName = movieList[movie]) { movie ->
                    Log.d("ReelView", "Movie clicked: $movie")
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieRow(movieName: String, onItemClick: (String) -> Unit = {}) {
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
            onItemClick(movieName)
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
                text = movieName,
                modifier = Modifier,
                style = MaterialTheme.typography.headlineSmall
            )
        }


    }
}

@Composable
fun MovieThumbnail() {

}

@Preview(showBackground = true)
@Composable
fun ReelViewPreview() {
    ReelViewApp {
        MainContent()
    }
}