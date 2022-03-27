package com.example.learningsupportapplication.presentation.screen.add_new_card

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.presentation.common.StudyCardSheet

@Composable
fun AddNewStudyCard(
    navController: NavHostController,

) {
    var text1 : String = ""
    var text2 : String = ""

    var text3 : String = ""
    var text4 : String = ""

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        StudyCardSheet(
            studyCardPageTwo = {
                text3 = it
            } ,
            studyCardPageOneText = text1,
            studyCardPageOne = {
                text4 = it
            },
            studyCardPageTwoText = text2,
            painter = painterResource(id =  R.drawable.ic_launcher_background)
        )
    }


}