package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
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
                TypeButton(
                    onCLick = { /*TODO*/ },
                    textColor = Color.LightGray,
                    categoryEntry = item
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }
}

@Composable
fun TypeButton(
    onCLick: () -> Unit,
    textColor: Color,
    categoryEntry: CategoryInfo
) {
        Button(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp)),
            onClick = onCLick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
        ) {
            Text(
                text = categoryEntry.strCategory,
                color = textColor,
            )
        }
}