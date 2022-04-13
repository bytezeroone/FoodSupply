package com.bytezeroone.foodsupply.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ManageAccounts
import androidx.compose.material.icons.outlined.RestaurantMenu
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomRoutes(val route: String, val icon: ImageVector, val label: String) {
    object Home: BottomRoutes("front_page", Icons.Outlined.RestaurantMenu, label = "Меню")
    object Profile: BottomRoutes("profile_screen", Icons.Outlined.ManageAccounts, label = "Профиль")
    object Cart: BottomRoutes("cart_screen", Icons.Outlined.ShoppingCart, label = "Корзина")
}


//menu, profile, cart