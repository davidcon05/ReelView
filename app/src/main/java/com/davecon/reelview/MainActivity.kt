package com.davecon.reelview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
            modifier = Modifier.fillMaxSize(),
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
                    navigationIcon = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Localized description"
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            val padding = innerPadding
            content()
        }
    }
}

@Composable
fun MainContent() {
    Surface(modifier = Modifier, color = MaterialTheme.colorScheme.background) {
        Text("Hello Reel View app!")
    }
}

@Preview(showBackground = true)
@Composable
fun ReelViewPreview() {
    ReelViewTheme {
        ReelViewApp {
            MainContent()
        }
    }
}