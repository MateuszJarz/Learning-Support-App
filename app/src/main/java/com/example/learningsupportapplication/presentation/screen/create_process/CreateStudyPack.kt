package com.example.learningsupportapplication.presentation.screen.create_process

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun CreateStudyPack(
    navController : NavHostController
) {
    CreateStudyPackItems()
}

@Composable
fun CreateStudyPackItems() {
    var text by remember {
        mutableStateOf(TextFieldValue(""))
    }
    Scaffold(

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(LARGE_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Text(text = "Name")

            OutlinedTextField(
                modifier = Modifier
                    .width(322.dp)
                    .height(96.dp),
                value = text,
                shape = RoundedCornerShape(SMALL_PADDING),
                onValueChange = { newText ->
                    text = newText
                },
                placeholder = {
                    Text(
                        text = "Package name: ",
                        textAlign = TextAlign.Center
                    )
                }
            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(SMALL_PADDING),
                border = BorderStroke(BORDER_SIZE, Color.Black),
                onClick = { TODO() }
            ) {
                Text(
                    text = "NEXT",
                    color = Color.Black
                )
            }
        }
    }
}


@Preview
@Composable
fun CreateStudyPackItemsPreview() {
    CreateStudyPackItems()
}
