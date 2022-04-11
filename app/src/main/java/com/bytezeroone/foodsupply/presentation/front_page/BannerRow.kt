package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.bytezeroone.foodsupply.R

@Composable
fun BannerRow() {
    //val painter = painterResource(id = listOf<Banner>())
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .size(196.dp)
            .padding(8.dp)
    ) {
        items(1) {
            Image(
                painter = painterResource(id = R.drawable.pizza_banner1),
                contentDescription = "pizza1",
                Modifier
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.pizza_banner2),
                contentDescription = "pizza2",
                Modifier
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                painter = painterResource(id = R.drawable.pizza_banner3),
                contentDescription = "pizza3",
                Modifier
                    .clip(RoundedCornerShape(8.dp))
            )

        }
    }
}