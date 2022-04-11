package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel


@Composable
fun FrontPageScreen(
) {
    Column {
        TopBar()
        ItemList()
    }
}