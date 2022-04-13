package com.bytezeroone.foodsupply.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.bytezeroone.foodsupply.navigation.BottomRoutes

@Composable
fun BottomBar(
    navController: NavController,
) {
    var selectedColor = Color.Gray
    val screens = listOf(
        BottomRoutes.Home,
        BottomRoutes.Profile,
        BottomRoutes.Cart
    )
    BottomNavigation(
        backgroundColor = Color.LightGray,
        contentColor = Color.Red
    ) {
        screens.forEach { screen ->
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
                selectedContentColor = selectedColor,
                unselectedContentColor = selectedColor,
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(screen.route) {
                        //aunchSingleTop = true
                    }
                    selectedColor = Color.Red
                }
            )
        }
    }
}
