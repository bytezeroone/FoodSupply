package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.QrCode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxHeight(0.05f)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Row {
                Text(text = "Москва")
                Icon(
                    Icons.Filled.KeyboardArrowDown,
                    contentDescription = "Search Button"
                )
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Filled.QrCode,
                contentDescription = "Search Button"
            )
        }
    }
}