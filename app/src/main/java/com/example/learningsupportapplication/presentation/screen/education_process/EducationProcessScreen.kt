package com.example.learningsupportapplication.presentation.screen.education_process


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.components.DisplayDialogAfterLearning
import com.example.learningsupportapplication.presentation.components.DraggableCard
import com.example.learningsupportapplication.presentation.screen.education_process.card_screen.PageOneContent
import com.example.learningsupportapplication.presentation.screen.education_process.card_screen.PageTwoContent
import com.example.learningsupportapplication.ui.theme.DarkGray
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

    var goodAnswers by remember { mutableStateOf(0) }
    var badAnswers by remember { mutableStateOf(0) }

    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        DisplayDialogAfterLearning(

            title = "WOW!",
            message = "That's all for to day !",
            goodAnswers = goodAnswers,
            badAnswers = badAnswers,
            openDialog = { openDialog.value = it },
            closeDialog = {
                navController.navigate(Screen.Home.route)
                openDialog.value = false
            }
        )
    }


    val isListEmpty = remember { mutableStateOf(false) }

    studyCards.value?.forEachIndexed { index, studyCard ->
        HandleEducationProcess(
            studyCard = studyCard,
            learningCardState = learningCardState.value,
            isListEmpty = isListEmpty,
            onSwiped = { swipeResult, _ ->

                if (swipeResult == SwipeResult.ACCEPTED) {
                    goodAnswers++
                } else {
                    badAnswers++
                }

                studyCards.value?.remove(studyCard)
                learningCardState.value = LearningCardState.ON_QUESTION
                if (studyCards.value?.isEmpty()?.or(false) == true) {
                    isListEmpty.value = true
                    studyCards.value?.removeAll(listOf(studyCard))
                    openDialog.value = true

                }


            },
            onNextClicked = {


                if (studyCards.value?.isNotEmpty()?.or(false) == true) {
                    learningCardState.value = LearningCardState.ON_ANSWER
                }
            },
            onKnowClicked = {
                goodAnswers++
                studyCards.value?.remove(studyCard)
                learningCardState.value = LearningCardState.ON_QUESTION
                if (studyCards.value?.isEmpty()?.or(false) == true) {
                    isListEmpty.value = true
                    studyCards.value?.removeAll(listOf(studyCard))
                    openDialog.value = true

                }
            },
            onDontKnowClicked = {
                badAnswers++
                studyCards.value?.remove(studyCard)
                learningCardState.value = LearningCardState.ON_QUESTION
                if (studyCards.value?.isEmpty()?.or(false) == true) {
                    isListEmpty.value = true
                    studyCards.value?.removeAll(listOf(studyCard))
                    openDialog.value = true

                }
            }

        )


    }
}


@Composable
fun HandleEducationProcess(
    studyCard: StudyCard,
    learningCardState: LearningCardState,
    isListEmpty: MutableState<Boolean>,
    onSwiped: (Any, Any) -> Unit,
    onNextClicked: () -> Unit,
    onKnowClicked: () -> Unit,
    onDontKnowClicked: () -> Unit,


    ) {
    when (learningCardState) {

        LearningCardState.ON_QUESTION -> {

            PageTwoContent(
                studyCard = studyCard,
                text = studyCard.firstPage,
                onClicked = onNextClicked
            )
        }

        LearningCardState.ON_ANSWER -> {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(DarkGray)

            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DraggableCard(
                        item = studyCard,
                        modifier = Modifier
                            .weight(9f)
                            .background(Color.LightGray)
                            .padding(
                                top = 16.dp,
                                bottom = 16.dp,
                                start = 16.dp,
                                end = 16.dp
                            ),
                        onSwiped = { swipeResult, swipeCard ->
                            onSwiped(swipeResult, swipeCard)
                        },
                        content = {
                            PageOneContent(studyCard = studyCard, text = studyCard.secondPage)
                        })
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .weight(1f)
                    ) {
                        Button(modifier = Modifier
                            .size(height = 40.dp, width = 140.dp),
                            shape = RoundedCornerShape(SMALL_PADDING),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Red.copy(
                                    alpha = 0.7f
                                )
                            ),
                            onClick = { onDontKnowClicked() }
                        ) {
                            Text(text = "I don't know")
                        }
                        Button(modifier = Modifier
                            .size(height = 40.dp, width = 140.dp),
                            shape = RoundedCornerShape(SMALL_PADDING),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color.Green.copy(
                                    alpha = 0.7f
                                )
                            ),
                            onClick = { onKnowClicked() }
                        ) {
                            Text(text = "I know")
                        }
                    }
                }

            }


        }
        else -> {}

    }
}








