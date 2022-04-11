package com.bytezeroone.foodsupply.data.remote.responses


import com.google.gson.annotations.SerializedName

data class ChickenFood(
    @SerializedName("meals")
    val meals: List<Meal>
)