package com.mihser.foodtalker.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.mihser.foodtalker.swipeable_cards.randomizer.SwipeableCardState
import com.mihser.foodtalker.swipeable_cards.randomizer.rememberSwipeableCardState
import com.mihser.foodtalker.swipeable_cards.randomizer.swipableCard


@Composable
fun SwipeableCardsStack(viewModel: DishesRandomizerViewModel, swipeableCardState: SwipeableCardState, modifier: Modifier = Modifier) {
    val cardStack by viewModel.availableDishesState.collectAsState()

    Box(modifier = modifier.background(
        color = Color.Blue,
        shape = RoundedCornerShape(16.dp) // You can use other shapes like small, large, etc.
    )) {
        cardStack.takeLastTwoOrOne().forEachIndexed { index, cardHolder ->
            Box(modifier = Modifier
                .then(if (index == 1 || cardStack.size == 1) {
                    Modifier.swipableCard(
                        state = swipeableCardState,
                        onSwiped = {
                            viewModel.dropLast()
                        }
                    )
                } else Modifier)
                .background(
                    color = Color.Blue,
                    shape = MaterialTheme.shapes.medium // You can use other shapes like small, large, etc.
                )
                .fillMaxSize()
            ) {
                LocalOrRemoteImage(cardHolder, modifier.fillMaxSize())
                Text(
                    cardHolder.name,
                    style = TextStyle(fontSize = 20.sp, color = Color.White),
                    modifier = Modifier.padding(12.dp)
                )
            }
        }
    }
}

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun LocalOrRemoteImage(cardHolder: DishHolder, modifier: Modifier) {
    if (cardHolder.localDrawableRes != null) {
        // Create a Painter from the Uri
        val imagePainter: Painter = painterResource(cardHolder.localDrawableRes)
        Image(
            painter = imagePainter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    } else {
//        GlideImage(model = cardHolder.uri, contentDescription = "", modifier = Modifier.fillMaxSize())
    }
}

private fun <T> List<T>.takeLastTwoOrOne(): List<T> {
    return when {
        this.size >= 2 -> this.takeLast(2)
        this.size == 1 -> this.takeLast(1)
        else -> emptyList()
    }
}