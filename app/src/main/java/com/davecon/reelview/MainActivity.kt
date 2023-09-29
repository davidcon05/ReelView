package com.davecon.reelview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.davecon.reelview.navigation.Navigation
import com.davecon.reelview.ui.theme.ReelViewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReelViewApp {
                Navigation()
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
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun ReelViewPreview() {
    ReelViewApp {

    }
}