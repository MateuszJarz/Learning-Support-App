package com.example.learningsupportapplication.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

@Composable
fun StudyPackList(
    studyPackages: List<StudyPack>,
    navController: NavController
) {
    val coroutineScope = rememberCoroutineScope()
    LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(studyPackages) { studyPack ->
            StudyPackItem(
                studyPack = studyPack,
                onClick = {
                    coroutineScope.launch {
                        navController.navigate(Screen.EducationProcess.passEduPackId(studyPackId = studyPack.id))
                        Log.d("SPL" ,studyPack.id.toString())
                    }
                    Log.d("SPL" ,studyPack.id.toString())
                }
            )
        }
    }

}

@Composable
fun StudyPackItem(
    studyPack: StudyPack,
   onClick: () -> Unit) {
    SelectionFieldItem(
        titleText = studyPack.studyPackName,
        buttonName = stringResource(R.string.start_button),
        onClick = { onClick()}
            )
        }


@Preview
@Composable
fun StudyPackItemPreview() {
    StudyPackItem(StudyPack(id = 1, studyPackName = "Test"), onClick = {})
}