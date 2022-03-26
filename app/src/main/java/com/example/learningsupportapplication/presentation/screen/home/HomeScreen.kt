package com.example.learningsupportapplication.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.common.SelectionField
import com.example.learningsupportapplication.presentation.common.StudyPackList
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING

/*
    * 1. Field with button to create new StudyPack
    * - button
    * 2. List with all created StudyPack
    * - start button
    * - name of pack
    * - */

@Composable
fun HomeScreen(
    navController: NavHostController
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LARGE_PADDING),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HomeCreateStudyPack(navController = navController)
        StudyPackList(
            studyPackages = listOf(
                StudyPack(id = 1, studyPackName = "test1"),
                StudyPack(id = 2, studyPackName = "test2")
            ), navController = navController
        )
    }
}

@Composable
fun HomeCreateStudyPack(
    navController: NavHostController
) {

    SelectionField(
        titleText = "Add new Study Pack!",
        buttonName = stringResource(R.string.create_button),
        onClick = {
            navController.navigate(Screen.CreateStudyPack.route)
        }
    )
}

