package com.bytezeroone.foodsupply.data.remote

import com.bytezeroone.foodsupply.data.remote.responses.ChickenFood
import com.bytezeroone.foodsupply.data.remote.responses.FoodCategory
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {


    @GET("1/filter.php?c=Chicken")
    suspend fun getChickenFoodInfoList(): ChickenFood

    @GET("1/filter.php?c={name}")
    suspend fun getFoodInfoListByName(
        @Path("name") name: String
    ): ChickenFood

    @GET("1/categories.php")
    suspend fun getCategoriesList(): FoodCategory

    companion object {
        const val BASE_URL = "https://www.themealdb.com/api/json/v1/"
    }
}