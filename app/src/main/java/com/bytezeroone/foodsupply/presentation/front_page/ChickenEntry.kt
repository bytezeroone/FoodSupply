package com.bytezeroone.foodsupply.presentation.front_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.bytezeroone.foodsupply.data.remote.responses.Meal

@Composable
fun ChickenEntry(
    entry: Meal,
    modifier: Modifier = Modifier
) {
    Box(
        //contentAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .height(192.dp)
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start
        ) {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(entry.strMealThumb)
                    .crossfade(true)
                    .build()
            )

            val painterState = painter.state

            if (painterState is AsyncImagePainter.State.Loading) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .scale(0.5f)
                )
            }
            Image(
                painter = painter,
                contentDescription = "entry image",
                modifier = Modifier
                    .size(192.dp)
                    //.align(Alignment.CenterStart)
                    .padding(8.dp),
            )
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    // modifier = Modifier.weight(0.2f),
                    text = entry.idMeal,
                    fontSize = 16.sp,
                    fontWeight = Bold

                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.weight(0.6f),
                    text = entry.strMeal,
                    fontSize = 12.sp
                )
                Button(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .align(Alignment.End)
                    ,
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
                ) {
                    Text(text = "price")
                }
            }
        }
    }
}