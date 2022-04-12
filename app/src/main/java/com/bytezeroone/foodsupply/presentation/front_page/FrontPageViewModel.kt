package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bytezeroone.foodsupply.data.remote.responses.ChickenFood
import com.bytezeroone.foodsupply.domain.model.CategoryInfo
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

    //TODO error loading
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)

    var chickenList = mutableStateOf<List<FoodInfo>>(listOf())

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
                    val foodEntries = result.data!!.meals.mapIndexed { index, entry ->
                        FoodInfo(entry.idMeal, entry.strMeal, entry.strMealThumb)

                    }
                    chickenList.value += foodEntries
                }
                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }
                else -> Unit
            }
        }
    }

    var categoriesList = mutableStateOf<List<CategoryInfo>>(listOf())

    fun loadCategories() {
        viewModelScope.launch {
            isLoading.value = true
            val result = repository.getCategoriesInfos()
            when (result) {
                is Resource.Success -> {
                    val categoryEntry = result.data!!.categories.mapIndexed { index, category ->
                        CategoryInfo(category.idCategory, category.strCategory, category.strCategoryDescription, category.strCategoryThumb)
                    }
                    categoriesList.value += categoryEntry
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

