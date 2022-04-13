package com.bytezeroone.foodsupply.presentation.profile_screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bytezeroone.foodsupply.presentation.BottomBar

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {

    }
}