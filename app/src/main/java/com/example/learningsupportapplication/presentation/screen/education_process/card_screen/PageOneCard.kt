package com.example.learningsupportapplication.presentation.screen.education_process.card_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import com.example.learningsupportapplication.ui.theme.cardItemBackgroundColor


@Composable
fun PageOneContent(
    studyCard: StudyCard,
    text: String,


    ) {
    /*Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.LightGray,
    ) {*/

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(SMALL_PADDING)
            .background(
                MaterialTheme.colors.cardItemBackgroundColor,
                shape = RoundedCornerShape(SMALL_PADDING)
            ),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier

                .weight(7f)

        ) {
            studyCard.image.let { bitmap ->
                if (bitmap != null) {
                    Image(
                        modifier = Modifier
                            .size(220.dp)
                            .align(Alignment.Center),
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Bitmap Image",
                        contentScale = ContentScale.Fit,

                        )
                } else {
                    Image(
                        modifier = Modifier
                            .size(220.dp)
                            .align(Alignment.Center),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,

                        )
                }

            }
        }

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = SMALL_PADDING)
                .weight(2f),
            text = text,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold

        )


    }


}


@Preview
@Composable
fun PageOneContentPrev() {
    PageOneContent(
        studyCard = StudyCard(
            id = 1,
            idStudyPack = 1,
            firstPage = "RandomText",
            secondPage = "",
            image = null

        ),
        text = "random text",

        )
}
