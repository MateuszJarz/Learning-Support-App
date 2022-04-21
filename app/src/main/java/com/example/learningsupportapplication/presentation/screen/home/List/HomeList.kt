package com.example.learningsupportapplication.presentation.common

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.screen.home.List.EmptyList
import com.example.learningsupportapplication.ui.theme.LIST_ITEM_PADDING
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun HandleStudyPackList(
    studyPackages: List<StudyPack>,
    navController: NavController
) {
    if (studyPackages.isEmpty()) {
        EmptyList()
    } else {
        StudyPackList(
            studyPackages = studyPackages,
            navController = navController

        )
    }
}

@ExperimentalMaterialApi
@Composable
fun StudyPackList(
    studyPackages: List<StudyPack>,
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        modifier = Modifier.padding(start = LIST_ITEM_PADDING, end = LIST_ITEM_PADDING)
    ) {
        items(studyPackages) { studyPack ->

            StudyPackItem(
                studyPack = studyPack,
                onClickButton = {
                    coroutineScope.launch {
                        navController.navigate(Screen.EducationProcess.passEduPackId(studyPackId = studyPack.id))

                    }

                },

                onClickIconButton = {
                    navController.navigate(
                        Screen.EditStudyPack.passStudyPackId(studyPackId = studyPack.id)
                    )
                }
            )
        }
    }

}

@ExperimentalMaterialApi
@Composable
fun StudyPackItem(
    studyPack: StudyPack,
    onClickButton: () -> Unit,
    onClickIconButton: () -> Unit
) {

    ListItem(
        title = studyPack.studyPackName,
        onClickButton = { onClickButton() },
        onClickIconButton = { onClickIconButton() }
    )


}
