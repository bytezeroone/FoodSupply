package com.bytezeroone.foodsupply.domain.model

data class FoodInfo(
    val name: String,
    val id: String,
    val imageUrl: String,
)

data class CategoryInfo(
    val idCategory: String,
    val strCategory: String,
    val strCategoryDescription: String,
    val strCategoryThumb: String
)