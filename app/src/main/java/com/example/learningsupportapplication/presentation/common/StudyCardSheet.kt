package com.example.learningsupportapplication.presentation.common

import android.graphics.Bitmap
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
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING


@Composable
fun StudyCardSheet(
    pageOneText: String,
    pageTwoText: String,
    pageOneTextChange: (String) -> Unit,
    pageTwoTextChange: (String) -> Unit,
    bitmap: Bitmap?,
    onClickChoosePhoto: () -> Unit,
    onClickAdd: () -> Unit,
    onClickCreate: () -> Unit

) {

    Column(
        modifier = Modifier.padding(SMALL_PADDING),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        CardSheetItem(
            pageOneText = pageOneText,
            pageTwoText = pageTwoText,
            pageOneTextChange = pageOneTextChange,
            pageTwoTextChange = pageTwoTextChange
        )
        PhotoCardItem(
            bitmap = bitmap,
            onClickChoosePhoto = onClickChoosePhoto
        )
        ButtonsCard(
            onClickAdd = onClickAdd,
            onClickCreate = onClickCreate
        )
    }


}

@Composable
fun CardSheetItem(
    pageOneText: String,
    pageTwoText: String,
    pageOneTextChange: (String) -> Unit,
    pageTwoTextChange: (String) -> Unit,
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
            value = pageOneText,
            shape = RoundedCornerShape(SMALL_PADDING),
            onValueChange = {
                pageOneTextChange(it)
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
            value = pageTwoText,
            shape = RoundedCornerShape(SMALL_PADDING),
            onValueChange = {
                pageTwoTextChange(it)
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
    bitmap: Bitmap?,
    onClickChoosePhoto: () -> Unit
) {


    Row {

        bitmap.let { bitmap ->
            if (bitmap != null) {
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = null,
                    modifier = Modifier.size(100.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "Select image from gallery")
                Button(
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    shape = RoundedCornerShape(SMALL_PADDING),
                    border = BorderStroke(BORDER_SIZE, Color.Black),
                    onClick = {
                        onClickChoosePhoto()


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
}

@Composable
fun ButtonsCard(
    onClickAdd: () -> Unit,
    onClickCreate: () -> Unit
) {

    Row {
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(SMALL_PADDING),
            border = BorderStroke(BORDER_SIZE, Color.Black),
            onClick = {
                onClickAdd()
            }
        ) {
            Text(
                text = "ADD",
                color = Color.Black
            )
        }

        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            shape = RoundedCornerShape(SMALL_PADDING),
            border = BorderStroke(BORDER_SIZE, Color.Black),
            onClick = {
                onClickCreate()
            }
        ) {
            Text(
                text = "CREATE STUDY PACK",
                color = Color.Black
            )
        }
    }

}


@Preview(showBackground = true)
@Composable
fun CardSheetItemPreview() {

}

@Preview
@Composable
fun PhotoCardItemPreview() {

}