package com.davecon.reelview.component

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun reelViewAppBar(
    movieName: String?,
    navController: NavController,
    navIcon: @Composable () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.shadow(16.dp),
        title = {
            Text(
                text = "$movieName",
                fontSize = 24.sp,
                style = MaterialTheme.typography.titleMedium
            )
        },
        navigationIcon = {
            navIcon()
        }
    )
}