package com.mihser.foodtalker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mihser.foodtalker.swipeable_cards.randomizer.rememberSwipeableCardState
import com.mihser.foodtalker.swipeable_cards.randomizer.swipableCard
import com.mihser.foodtalker.ui.screens.DishesRandomizerScreen
import com.mihser.foodtalker.ui.screens.DishesRandomizerViewModel
import com.mihser.foodtalker.ui.screens.SwipeableCardsStack
import com.mihser.foodtalker.ui.theme.FoodtalkerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodtalkerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DishesRandomizerScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    val state = rememberSwipeableCardState()

//    Box(modifier = Modifier
//        .fillMaxSize()
//        .swipableCard(
//            state = state,
//            onSwiped = {
//
//            }
//        ), contentAlignment = Alignment.Center)
//    {
//        Box(
//            modifier = Modifier
//                .background(Color.Blue)
//                .size(300.dp)
//        ) {
//            Text("Hello world!", style = TextStyle(fontSize = 22.sp))
//        }
//    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FoodtalkerTheme {
        Greeting("Android")
    }
}