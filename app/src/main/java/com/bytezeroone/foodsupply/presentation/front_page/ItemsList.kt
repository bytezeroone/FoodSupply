package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bytezeroone.foodsupply.data.remote.responses.Category
import com.bytezeroone.foodsupply.data.remote.responses.ChickenFood
import com.bytezeroone.foodsupply.util.Resource

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ItemList(
    viewModel: FrontPageViewModel = hiltViewModel()
) {
    val chickenState = viewModel.chickenList
    val categoriesState = viewModel.categoriesList

    /*val categorySelected = produceState<Resource<ChickenFood>>(initialValue = Resource.Loading()) {
        value = viewModel.getChickenInfosByName(name)
    }.value*/

    //val categoryState = viewModel.categoriesList
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
    ) {
        item {
            BannerRow()
        }
        stickyHeader {
            FoodTypeRow()
        }
        items(chickenState.size) { i ->
            val item = chickenState[i]
            viewModel.loadChicken()
            ChickenEntry(entry = item)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}