package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
        color = colors.background

    ) {
        LazyRow(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        ) {
            items(categoriesState.size) { i ->
                val item = categoriesState[i]
                TypeCategory(
                    onCLick = {

                    },
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
    categoryEntry: CategoryInfo,
) {
    /*val buttonColorState = remember {
        mutableStateOf(true)
    }*/

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

