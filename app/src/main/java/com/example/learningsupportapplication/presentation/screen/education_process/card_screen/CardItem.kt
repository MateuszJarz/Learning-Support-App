package com.example.learningsupportapplication.presentation.screen.education_process.card_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun CardItem(
    modifier: Modifier = Modifier,
    studyCard: StudyCard,
    text: String,

    ) {




}

@Preview
@Composable
fun CardItemPrev() {
    CardItem(
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



