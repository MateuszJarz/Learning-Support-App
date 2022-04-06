package com.example.learningsupportapplication.presentation.screen.education_process


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.presentation.components.DraggableCardAndNormalCard


@SuppressLint("StateFlowValueCalledInComposition", "UnrememberedMutableState")
@Composable
fun EducationProcess(
    navController: NavHostController,
    educationProcessViewModel: EducationProcessViewModel = hiltViewModel(),
) {

    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val cardHeight = screenHeight - 200.dp

    val studyCards = educationProcessViewModel.studyCards
    val check = educationProcessViewModel.check

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier.background(
                Color.Magenta,
            )

        ) {
            val listEmpty = remember { mutableStateOf(false) }

            studyCards.value?.forEachIndexed { index, studyCard ->

                DraggableCardAndNormalCard(
                    item = studyCards,
                    check = check,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(cardHeight)
                        .padding(
                            top = 16.dp + (index + 2).dp,
                            bottom = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                        ),

                    onButtonClick = {

                        check.value = false
                        studyCards.value?.remove(studyCard)

                    },
                    onSwiped = { _, studyCardy ->
                        if (studyCards.value?.isNotEmpty()?.or(false) == true) {
                            studyCards.value?.remove(studyCard)
                            if (studyCards.value?.isEmpty()?.or(false) == true) {
                                listEmpty.value = true
                            }
                        }
                    },
                    content1 = { CardContent(studyCard = studyCard, text = studyCard.firstPage) },
                    content2 = { CardContent(studyCard = studyCard, text = studyCard.secondPage) }
                )


            }


        }
    }
}


@Composable
fun CardContent(
    studyCard: StudyCard,
    text: String
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.weight(1f)
        )

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
