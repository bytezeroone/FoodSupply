package com.bytezeroone.foodsupply.navigation.nav_graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.bytezeroone.foodsupply.navigation.BottomRoutes
import com.bytezeroone.foodsupply.presentation.cart_screen.CartScreen
import com.bytezeroone.foodsupply.presentation.front_page.FrontPageScreen
import com.bytezeroone.foodsupply.presentation.profile_screen.ProfileScreen


fun NavGraphBuilder.bottomNavGraph(
    navController: NavController
) {
    composable(BottomRoutes.Home.route) {
        FrontPageScreen(navController)
    }

    composable(BottomRoutes.Profile.route) {
        ProfileScreen(navController)
    }

    composable(BottomRoutes.Cart.route) {
        CartScreen(navController)
    }
}