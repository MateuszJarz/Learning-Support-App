package com.example.learningsupportapplication.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun DisplayDialogAfterLearning(

    title: String,
    message: String,
    goodAnswers: Int,
    badAnswers: Int,
    openDialog: (Boolean) -> Unit,
    closeDialog: () -> Unit,
) {
    Dialog(
        onDismissRequest = {
            closeDialog()
        openDialog(false)
        },

    ) {
        Surface(
            shape = RoundedCornerShape(SMALL_PADDING),
            color = Color.White
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = title,
                    fontSize = MaterialTheme.typography.h3.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(bottom = LARGE_PADDING),
                    text = message,
                    fontSize = MaterialTheme.typography.subtitle2.fontSize,
                    fontWeight = FontWeight.Bold
                )

                PiaChart(goodAnswers = goodAnswers, badAnswers = badAnswers)

                Box(modifier = Modifier.padding(SMALL_PADDING)) {
                    Button(
                        onClick = {
                            closeDialog()

                        }
                    ) {
                        Text(text = "Done")
                    }
                }
            }

        }


    }
}

