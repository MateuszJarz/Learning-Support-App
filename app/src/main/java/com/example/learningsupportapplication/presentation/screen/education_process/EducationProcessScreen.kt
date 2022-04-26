package com.example.learningsupportapplication.presentation.screen.education_process


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.presentation.components.DraggableCard
import com.example.learningsupportapplication.presentation.screen.education_process.card_screen.PageOneContent
import com.example.learningsupportapplication.presentation.screen.education_process.card_screen.PageTwoContent
import com.example.learningsupportapplication.ui.theme.DarkGray
import com.example.learningsupportapplication.ui.theme.cardItemBackgroundColor
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


    val isListEmpty = remember { mutableStateOf(false) }

    studyCards.value?.forEachIndexed { index, studyCard ->
        HandleEducationProcess(
            studyCard = studyCard,
            learningCardState = learningCardState.value,
            isListEmpty = isListEmpty,
            onSwiped = { swipeResult, _ ->


                if (swipeResult == SwipeResult.ACCEPTED || swipeResult == SwipeResult.REJECTED) {
                    if (studyCards.value?.isEmpty()?.or(false) == true) {
                        isListEmpty.value = true
                        studyCards.value?.removeAll(listOf(studyCard))
                    }
                }
                if (studyCards.value?.isNotEmpty()?.or(false) == true) {
                    learningCardState.value = LearningCardState.ON_ANSWER
                }


            },
            onNextClicked = {
                studyCards.value?.remove(studyCard)
                learningCardState.value = LearningCardState.ON_QUESTION
                if (studyCards.value?.isEmpty()?.or(false) == true) {
                    isListEmpty.value = true
                    studyCards.value?.removeAll(listOf(studyCard))
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

    ) {
    when (learningCardState) {

        LearningCardState.ON_QUESTION -> {
            Surface(
                modifier = Modifier.fillMaxSize().background(DarkGray)

            ) {
                DraggableCard(
                    item = studyCard,
                    modifier = Modifier
                        .fillMaxSize()
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
                        PageOneContent(studyCard = studyCard, text = studyCard.firstPage)
                    })
            }


        }

        LearningCardState.ON_ANSWER -> {
            PageTwoContent(
                studyCard = studyCard,
                text = studyCard.secondPage,
                onClicked = onNextClicked
            )
        }
        else -> {}

    }
}








