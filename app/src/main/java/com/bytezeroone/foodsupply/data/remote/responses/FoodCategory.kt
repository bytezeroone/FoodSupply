package com.bytezeroone.foodsupply.data.remote.responses


import com.google.gson.annotations.SerializedName

data class FoodCategory(
    @SerializedName("categories")
    val categories: List<Category>
)