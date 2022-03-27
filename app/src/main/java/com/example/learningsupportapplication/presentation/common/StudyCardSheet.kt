package com.example.learningsupportapplication.presentation.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningsupportapplication.R.drawable
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING


@Composable
fun StudyCardSheet(
    studyCardPageOneText: String,
    studyCardPageTwoText: String,
    studyCardPageOne: (String) -> Unit,
    studyCardPageTwo: (String) -> Unit,
    painter: Painter
) {

    Column(
        modifier = Modifier.padding(SMALL_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CardSheetItem(
            studyCardPageOne = studyCardPageOne,
            studyCardPageOneText = studyCardPageOneText,
            studyCardPageTwo = studyCardPageTwo,
            studyCardPageTwoText = studyCardPageTwoText
        )
        PhotoCardItem(
            painter = painter
        )
        ButtonsCard()
    }


}

@Composable
fun CardSheetItem(
    studyCardPageOneText: String,
    studyCardPageTwoText: String,
    studyCardPageOne: (String) -> Unit,
    studyCardPageTwo: (String) -> Unit,
) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(SMALL_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        OutlinedTextField(
            modifier = Modifier
                .width(322.dp)
                .height(96.dp)
                .padding(bottom = SMALL_PADDING),
            value = studyCardPageOneText,
            shape = RoundedCornerShape(SMALL_PADDING),
            onValueChange = {
                studyCardPageOne(it)
            },
            placeholder = {
                Text(
                    text = "Study Card Page One : ",
                    textAlign = TextAlign.Center
                )
            }
        )
        OutlinedTextField(
            modifier = Modifier
                .width(322.dp)
                .height(96.dp),
            value = studyCardPageTwoText,
            shape = RoundedCornerShape(SMALL_PADDING),
            onValueChange = {
                studyCardPageTwo(it)
            },
            placeholder = {
                Text(
                    text = "Study Card Page Two : ",
                    textAlign = TextAlign.Center
                )
            }
        )

    }
}

@Composable
fun PhotoCardItem(
    painter: Painter
) {


    Row(

    ) {
        Image(painter = painter, contentDescription = "Card Image")

        Column(
            horizontalAlignment = Alignment.End
        ) {
            Text(text = "Choose a photo from gallery")
            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(SMALL_PADDING),
                border = BorderStroke(BORDER_SIZE, Color.Black),
                onClick = {
                    TODO()
                }
            ) {
                Text(
                    text = "Choose",
                    color = Color.Black
                )
            }
        }
    }


}

@Composable
fun ButtonsCard(

) {

    Row() {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(SMALL_PADDING),
            border = BorderStroke(BORDER_SIZE, Color.Black),
            onClick = {
                TODO()
            }
        ) {
            Text(
                text = "ADD",
                color = Color.Black
            )
        }
    }

}



@Preview(showBackground = true)
@Composable
fun CardSheetItemPreview() {
    CardSheetItem("", "", {}, {})
}

@Preview
@Composable
fun PhotoCardItemPreview() {
    PhotoCardItem(painter = painterResource(id = drawable.ic_launcher_background))
}