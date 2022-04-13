package com.bytezeroone.foodsupply.domain.repository

import com.bytezeroone.foodsupply.data.remote.FoodApi
import com.bytezeroone.foodsupply.data.remote.responses.ChickenFood
import com.bytezeroone.foodsupply.data.remote.responses.FoodCategory
import com.bytezeroone.foodsupply.util.Resource
import java.lang.Exception
import javax.inject.Inject


class FoodRepository @Inject constructor(
    private val api: FoodApi
) {

    suspend fun getChickenInfo(page: Int): Resource<ChickenFood> {
        val response = try {
            api.getChickenFoodInfoList(page)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    suspend fun getCategoriesInfos(): Resource<FoodCategory> {
        val response = try {
            api.getCategoriesList()
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }

    suspend fun getCategoriesInfosByName(name: String): Resource<ChickenFood> {
        val response = try {
            api.getFoodInfoListByName(name)
        } catch (e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }
}