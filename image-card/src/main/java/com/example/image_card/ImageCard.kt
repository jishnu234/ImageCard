package com.example.image_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun ImageCard(
    elevation: Int = 4,
    text: String,
    imageUrl: String,
    contentDescription: String
) {

    Box(
        modifier = Modifier
            .padding(4.dp)
            .shadow(elevation = elevation.dp,
                shape = RoundedCornerShape(12.dp),
                clip = true
            )
            .requiredWidthIn(min = 180.dp, max = 200.dp)
            .height(230.dp)
            .padding(2.dp)
            .clip(RoundedCornerShape(12.dp))

    ) {
        val painter = rememberImagePainter(
            data = imageUrl
        )
        Image(
            painter = painter,
            contentScale = ContentScale.FillBounds,
            contentDescription = contentDescription
        )
        if (painter.state is ImagePainter.State.Loading){
            CircularProgressIndicator(
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.Center),
                strokeWidth = 2.dp
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                    ),
                ).align(Alignment.BottomCenter)
                ){}
        Text(
            text = text,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp),
            maxLines = 2,
            color = Color.White,
            overflow = TextOverflow.Ellipsis,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp
        )
    }
}