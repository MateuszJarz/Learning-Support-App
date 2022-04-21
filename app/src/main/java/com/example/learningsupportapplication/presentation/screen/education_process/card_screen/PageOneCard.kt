package com.example.learningsupportapplication.presentation.screen.education_process.card_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
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
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import com.example.learningsupportapplication.ui.theme.cardItemBackgroundColor

@Composable
fun PageOneCard() {

}

@Composable
fun PageOneContent(
    modifier: Modifier = Modifier,
    studyCard: StudyCard,
    text: String,
    onClicked: () -> Unit,

    ) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(SMALL_PADDING),
        color = MaterialTheme.colors.cardItemBackgroundColor
    ) {
        Column(
            modifier = Modifier.padding(all = LARGE_PADDING),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            studyCard.image.let { bitmap ->
                if (bitmap != null) {
                    Image(
                        modifier = Modifier.weight(3f),
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Bitmap Image",
                        contentScale = ContentScale.Crop,

                        )
                } else {
                    Image(
                        modifier = Modifier.weight(3f),
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,

                        )
                }

            }


            Text(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f),
                text = text,
                style = MaterialTheme.typography.h4,

                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold

            )


        }
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
        onClicked = {}
    )
}
