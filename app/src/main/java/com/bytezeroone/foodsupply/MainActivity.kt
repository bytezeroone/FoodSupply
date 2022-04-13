package com.bytezeroone.foodsupply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.bytezeroone.foodsupply.data.remote.responses.Category
import com.bytezeroone.foodsupply.navigation.nav_graph.SetupNavGraph
import com.bytezeroone.foodsupply.presentation.front_page.FrontPageScreen
import com.bytezeroone.foodsupply.presentation.front_page.FrontPageViewModel
import com.bytezeroone.foodsupply.ui.theme.FoodSupplyTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodSupplyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    SetupNavGraph(navController = navController)
                    //FrontPageScreen(navController)
                }
            }
        }
    }
}

