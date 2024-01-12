package com.mihser.foodtalker.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mihser.foodtalker.R
import com.mihser.foodtalker.swipeable_cards.randomizer.rememberSwipeableCardState


@Composable
fun DishesRandomizerScreen(
    viewModel: DishesRandomizerViewModel = DishesRandomizerViewModel()
) {
    val state = rememberSwipeableCardState()
    Box(
        modifier = Modifier
            .height(500.dp)
            .width(300.dp), contentAlignment = Alignment.Center
    ) {
        Box(Modifier.height(500.dp)
            .width(300.dp), contentAlignment = Alignment.Center) {
            SwipeableCardsStack(viewModel, state)

            // Position the Row at the bottom of the Box
            Row(
                modifier = Modifier
                    .fillMaxWidth().align(Alignment.BottomCenter),

            ) {
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dislike_16),
                        contentDescription = ""
                    )
                }

                FloatingActionButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_like_16),
                        contentDescription = ""
                    )
                }
            }
        }
    }

}