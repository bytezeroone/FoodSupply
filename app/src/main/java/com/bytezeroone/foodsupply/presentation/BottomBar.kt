package com.bytezeroone.foodsupply.presentation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
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
        contentColor = Color.Red
    ) {
        screens.forEach { screen ->
            //val navBackStackEntry by navController.currentBackStackEntryAsState()
            //val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
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
                selected = false,
                onClick = {
                    /*navController.navigate(screen.route) {
                        //popUpToId = navController.graph.startDestinationId
                        //launchSingleTop = true
                    }*/
                }
            )
        }
    }
}
