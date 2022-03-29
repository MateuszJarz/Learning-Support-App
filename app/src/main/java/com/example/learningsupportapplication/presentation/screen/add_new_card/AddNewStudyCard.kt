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

    var currentListOfCards = addNewStudyCardViewModel.currentList


    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        StudyCardSheet(

            pageOneText = studyCardPageOneText,
            pageOneTextChange = { text1 ->
                studyCardPageOneText = text1
            },

            pageTwoText = studyCardPageTwoText,
            pageTwoTextChange = { text2 ->
                studyCardPageTwoText = text2
            },

            painter = painterResource(id = R.drawable.ic_launcher_background),

            onClickAdd = {
                addNewStudyCardViewModel.insertCardToCurrentList(
                    firstPage = studyCardPageOneText,
                    secondPage = studyCardPageTwoText
                )

            },
            onClickCreate = {
                addNewStudyCardViewModel.insertCardsToDataBase(currentListOfCards)
            }
        )
    }


}


