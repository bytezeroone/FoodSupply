package com.bytezeroone.foodsupply.presentation.front_page

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytezeroone.foodsupply.R
import com.bytezeroone.foodsupply.data.remote.responses.Category
import com.bytezeroone.foodsupply.data.remote.responses.ChickenFood
import com.bytezeroone.foodsupply.data.remote.responses.FoodCategory
import com.bytezeroone.foodsupply.data.remote.responses.Meal
import com.bytezeroone.foodsupply.domain.model.FoodInfo
import com.bytezeroone.foodsupply.domain.repository.FoodRepository
import com.bytezeroone.foodsupply.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FrontPageViewModel @Inject constructor(
    private val repository: FoodRepository
): ViewModel() {
    /*var textColor = mutableStateOf(Color.LightGray)

    fun textColorChange() {
        when (textColor.value) {
            Color.Red -> textColor.value = Color.LightGray
            Color.LightGray -> textColor.value = Color.Red
        }
    }*/

    private var curPage = 0

    var chickenList: List<Meal> by mutableStateOf(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    init {
        loadChicken()
        loadCategories()
    }

    fun loadChicken() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getChickenInfo()
            when (result) {
                is Resource.Success -> {
                    //endReached.value >= result.data!!
                    val chickenEntries = result.data!!.meals
                    chickenList = chickenEntries
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
                else -> Unit
            }
        }
    }

    var categoriesList: List<Category> by mutableStateOf(listOf())
    fun loadCategories() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getCategoriesInfos()
            when (result) {
                is Resource.Success -> {
                    val chickenEntries = result.data!!.categories
                    categoriesList = chickenEntries
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
                else -> Unit
            }
        }
    }

    suspend fun getChickenInfosByName(name: String): Resource<ChickenFood> {
        return repository.getCategoriesInfosByName(name)
    }

}

