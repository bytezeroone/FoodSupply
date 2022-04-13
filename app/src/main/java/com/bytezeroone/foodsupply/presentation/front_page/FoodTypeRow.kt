package com.bytezeroone.foodsupply.presentation.front_page

import android.widget.Toast
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bytezeroone.foodsupply.data.remote.responses.Category
import com.bytezeroone.foodsupply.domain.model.CategoryInfo

@Composable
fun FoodTypeRow(
) {
    val viewModel: FrontPageViewModel = hiltViewModel()
    val categoriesState by remember {
        viewModel.categoriesList
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background

    ) {
        LazyRow(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        ) {
            items(categoriesState.size) { i ->
                val item = categoriesState[i]
                TypeCategory(
                    onCLick = { /*TODO*/ },
                    categoryEntry = item
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun TypeCategory(
    onCLick: () -> Unit,
    categoryEntry: CategoryInfo
) {
    val interaction = remember { MutableInteractionSource() }
    val isPressed by interaction.collectIsPressedAsState()
    val color = if (isPressed) Color.Red else Color.LightGray
    Button(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp)),
        onClick = onCLick,
        interactionSource = interaction,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
    ) {
        Text(
            text = categoryEntry.strCategory,
            color = color,
        )
    }
}

