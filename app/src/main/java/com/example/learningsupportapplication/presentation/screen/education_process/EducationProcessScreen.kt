package com.example.learningsupportapplication.presentation.screen.education_process


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.presentation.components.DraggableCard
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import com.example.util.LearningCardState
import com.example.util.SwipeResult


@SuppressLint("StateFlowValueCalledInComposition", "UnrememberedMutableState")
@Composable
fun EducationProcess(
    navController: NavHostController,
    educationProcessViewModel: EducationProcessViewModel = hiltViewModel(),
) {

    val studyCards = educationProcessViewModel.studyCards
    var learningCardState = educationProcessViewModel.learningCardState
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val cardHeight = screenHeight - 200.dp

    Log.d("learningCardState", learningCardState.value.name)

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        val listEmpty = remember { mutableStateOf(false) }

        studyCards.value?.forEachIndexed { index, studyCard ->

            when (learningCardState.value) {

                LearningCardState.ON_QUESTION -> {

                    DraggableCard(
                        item = studyCard,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(cardHeight)
                            .padding(
                                top = 16.dp + (index + 2).dp,
                                bottom = 16.dp,
                                start = 16.dp,
                                end = 16.dp
                            ),
                        onSwiped = { swipeResult, swipedAlbum ->

                            if (swipeResult == SwipeResult.ACCEPTED || swipeResult == SwipeResult.ACCEPTED) {
                                if (studyCards.value?.isEmpty()?.or(false) == true) {
                                    listEmpty.value = true
                                    studyCards.value?.removeAll(listOf(studyCard))
                                }
                            }
                            if (studyCards.value?.isNotEmpty()?.or(false) == true) {
                                //studyCards.value?.remove(swipedAlbum)
                                learningCardState.value = LearningCardState.ON_ANSWER

                            }


                            /*if (swipeResult == SwipeResult.ACCEPTED || swipeResult == SwipeResult.REJECTED) {
                                learningCardState.value = LearningCardState.ON_ANSWER
                            }*/


                        },

                        ) {
                        CardContent(
                            studyCard = studyCard,
                            text = studyCard.firstPage
                        ) {}


                    }


                }

                LearningCardState.ON_ANSWER -> {

                    /* Surface(
                         modifier = Modifier.background(color = MaterialTheme.colors.background)
                     ) {}*/
                    Surface(
                        modifier = Modifier.fillMaxSize(),

                    ) {
                        Column(

                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CardContent(
                                modifier = Modifier.weight(1f),
                                studyCard = studyCard,
                                text = studyCard.secondPage,
                                onClicked = {}
                            )

                            Button(
                                modifier = Modifier.weight(2f),
                                onClick = {
                                    studyCards.value?.remove(studyCard)
                                    learningCardState.value = LearningCardState.ON_QUESTION
                                    if (studyCards.value?.isEmpty()?.or(false) == true) {
                                        listEmpty.value = true
                                        studyCards.value?.removeAll(listOf(studyCard))
                                    }
                                }) {
                                Text(text = "NEXT")
                            }
                        }
                    }


                }
            }


        }
    }
}


@Composable
fun CardContent(
    modifier: Modifier = Modifier,
    studyCard: StudyCard,
    text: String,
    onClicked: () -> Unit,

    ) {

        Column(
            modifier = Modifier.padding(all = LARGE_PADDING),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            studyCard.image.let { bitmap ->
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.weight(1f)
                    )
                }

            }

            Divider(Modifier.size(SMALL_PADDING))
            Text(
                text = text,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold

            )


        }
    }


/*

@Preview
@Composable
fun CardContentPrev() {
    CardContent(
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
}*/
