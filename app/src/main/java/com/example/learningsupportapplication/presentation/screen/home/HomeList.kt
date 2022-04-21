package com.example.learningsupportapplication.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun StudyPackList(
    studyPackages: List<StudyPack>,
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(

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


    /* SelectionFieldItem(
         titleText = studyPack.studyPackName,
         buttonName = stringResource(R.string.start_button),
         onClickButton = { onClickButton() },
         onClickIconButton = { onClickIconButton() }
     )*/
}

@ExperimentalMaterialApi
@Preview
@Composable
fun StudyPackItemPreview() {
    StudyPackItem(
        StudyPack(id = 1, studyPackName = "Test"),
        onClickButton = {},
        onClickIconButton = {})
}