package com.example.learningsupportapplication.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun SelectionField(
    titleText: String,
    buttonName: String
) {
    Surface(
        modifier = Modifier
            .width(322.dp)
            .height(96.dp),
        shape = RoundedCornerShape(LARGE_PADDING),
        border = BorderStroke(BORDER_SIZE, Color.Black),

    ) {
        Row(
            modifier = Modifier
                .padding(all = SMALL_PADDING),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            Text(
                text = titleText ,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Bold

            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(SMALL_PADDING),
                border = BorderStroke(BORDER_SIZE, Color.Black),
                onClick = { /*TODO*/ }
            ) {
                Text(
                    text = buttonName,
                    color = Color.Black
                )
            }
        }
    }
}

@Preview
@Composable
fun SelectionFieldPreview() {
    SelectionField("text","test")
}