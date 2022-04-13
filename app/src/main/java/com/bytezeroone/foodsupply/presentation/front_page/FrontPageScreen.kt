package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bytezeroone.foodsupply.presentation.BottomBar


@Composable
fun FrontPageScreen(
    navController: NavController
) {
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomBar(navController) }
    ) {
        ItemList()
    }
}