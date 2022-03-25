package com.example.learningsupportapplication.presentation.screen.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.ui.theme.*

/*
    * 1. Field with button to create new StudyPack
    * - button
    * 2. List with all created StudyPack
    * - start button
    * - name of pack
    * - */

@Composable
fun HomeScreen(
    navHostController: NavHostController
) {
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        HomeCreateStudyPack()
    }
}

@Composable
fun HomeCreateStudyPack() {

    Surface(
        shape = RoundedCornerShape(LARGE_PADDING),
        border = BorderStroke(BORDER_SIZE, Color.Black)
    ) {
        Row(
            modifier = Modifier
                .padding(all = SMALL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(
                text = "Add new Study Pack!",
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold

            )
            Button(
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = "Add"
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeCreateStudyPackPreview() {
    HomeCreateStudyPack()
}