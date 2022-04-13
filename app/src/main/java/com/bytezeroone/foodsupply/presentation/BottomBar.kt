package com.bytezeroone.foodsupply.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bytezeroone.foodsupply.navigation.BottomRoutes

@Composable
fun BottomBar(
    navController: NavController,
) {
    val screens = listOf(
        BottomRoutes.Home,
        BottomRoutes.Profile,
        BottomRoutes.Cart
    )
    BottomNavigation(
        backgroundColor = Color.LightGray,
        contentColor = Color.Gray
    ) {
        screens.forEach { screen ->
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                label = {
                    Text(text = screen.label)
                },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = true,
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}
