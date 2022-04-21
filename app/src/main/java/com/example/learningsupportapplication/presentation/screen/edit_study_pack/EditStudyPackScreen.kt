package com.example.learningsupportapplication.presentation.screen.edit_study_pack

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.domain.model.StudyCard

import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun EditStudyPackScreen(
    navController: NavHostController,
    editStudyPackViewModel: EditStudyPackViewModel = hiltViewModel()
) {
    val studyCards = editStudyPackViewModel.currentList

    Surface(modifier = Modifier.fillMaxSize()) {
        EditStudyPackList(studyCards = studyCards)
    }

}

@Composable
fun EditStudyPackList(
    studyCards: List<StudyCard>,
) {
    LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.Center
    ) {
        items(studyCards) { item: StudyCard ->
            Surface {
                item.image?.let { Image(bitmap = it.asImageBitmap(), contentDescription = null) }
                Text(text = item.firstPage)

            }

        }
    }
}