package com.bytezeroone.foodsupply.presentation.cart_screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.bytezeroone.foodsupply.presentation.BottomBar

@Composable
fun CartScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {

    }
}