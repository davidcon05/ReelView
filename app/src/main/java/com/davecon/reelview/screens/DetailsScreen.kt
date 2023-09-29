package com.davecon.reelview.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(navController: NavHostController, movieName: String?) {
    Text(text = "Details Screen: $movieName")
}