package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bytezeroone.foodsupply.data.remote.responses.Category

@Composable
fun FoodTypeRow(
) {
    val viewModel: FrontPageViewModel = hiltViewModel()
    val categoriesState = viewModel.categoriesList
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
    categoryEntry: Category
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

/**
 * @Composable
fun FilterType(
    filtertypes: FilterType,
    modifier: Modifier = Modifier
) {
    val (selected, setSelected) = filtertypes.enabled
    val background by animateColorAsState(
        if (selected) Color.Red else Color.White
    )
    val textColor by animateColorAsState(
        if (selected) Color.Green else Color.Black
    )
    Surface(

    ) {
        val interactionSource = remember { MutableInteractionSource() }

        val pressed by interactionSource.collectIsPressedAsState()
        val backgroundPressed =
            if (pressed) {
                Modifier.width(
                    100.dp
                )
            } else {
                Modifier.background(Color.Transparent)
            }
        Box(
            modifier = Modifier
                .toggleable(
                    value = selected,
                    onValueChange = setSelected,
                    interactionSource = interactionSource,
                    indication = null
                )
                .then(backgroundPressed)
        ) {
            Text(
                text = filtertypes.name,
                style = MaterialTheme.typography.caption,
                maxLines = 1,
                modifier = Modifier.padding(
                    horizontal = 20.dp,
                    vertical = 6.dp
                )
            )
        }
    }
}
*/