package com.example.learningsupportapplication.presentation.screen.add_new_card

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.presentation.common.StudyCardSheet


@Composable
fun AddNewStudyCard(
    navController: NavHostController,
    addNewStudyCardViewModel: AddNewStudyCardViewModel = hiltViewModel()

) {
    var studyCardPageOneText by addNewStudyCardViewModel.studyCardPageOneText
    var studyCardPageTwoText by addNewStudyCardViewModel.studyCardPageTwoText


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        StudyCardSheet(

            text = studyCardPageOneText,
            onTexChange = {
                studyCardPageOneText = it
            },
            painter = painterResource(id = R.drawable.ic_launcher_background),

            onClick = {
                addNewStudyCardViewModel.insertCardToCurrentList(
                    firstPage = studyCardPageOneText,
                    secondPage = studyCardPageTwoText
                )

            }
        )
    }


}


