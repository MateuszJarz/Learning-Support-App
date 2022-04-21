package com.example.learningsupportapplication.presentation.screen.education_process


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.presentation.components.DraggableCard
import com.example.learningsupportapplication.presentation.screen.education_process.card_screen.PageOneContent
import com.example.learningsupportapplication.presentation.screen.education_process.card_screen.PageTwoContent
import com.example.learningsupportapplication.util.LearningCardState
import com.example.learningsupportapplication.util.SwipeResult


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


    val listEmpty = remember { mutableStateOf(false) }

    studyCards.value?.forEachIndexed { index, studyCard ->

        when (learningCardState.value) {

            LearningCardState.ON_QUESTION -> {

                DraggableCard(
                    item = studyCard,
                    modifier = Modifier
                        .fillMaxSize()
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
                    PageOneContent(
                        studyCard = studyCard,
                        text = studyCard.firstPage
                    ) {}


                }


            }

            LearningCardState.ON_ANSWER -> {


                PageTwoContent(studyCard = studyCard, text = studyCard.secondPage) {

                }


            }
        }


    }
}

