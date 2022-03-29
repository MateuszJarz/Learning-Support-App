package com.example.learningsupportapplication.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.learningsupportapplication.R
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun StudyPackList(
    studyPackages: List<StudyPack>,
    navController: NavController
) {
    LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(studyPackages) { studyPack ->
            StudyPackItem(studyPack = studyPack)
        }
    }

}

@Composable
fun StudyPackItem(
    studyPack: StudyPack
) {
    SelectionFieldItem(
        titleText = studyPack.studyPackName,
        buttonName = stringResource(R.string.start_button),
        onClick = { TODO() }
    )
}

@Preview
@Composable
fun StudyPackItemPreview() {
    StudyPackItem(StudyPack(id = 1, studyPackName = "Test"))
}