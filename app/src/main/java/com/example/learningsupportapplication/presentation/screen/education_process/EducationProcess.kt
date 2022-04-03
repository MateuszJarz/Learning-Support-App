package com.example.learningsupportapplication.presentation.screen.education_process

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING

@Composable
fun EducationProcess(
    navController: NavHostController,
    viewModel: EducationProcessViewModel = hiltViewModel(),
    studyPack: StudyPack
) {

}

@Composable
fun CardScreen() {
    Surface(
        modifier =
        Modifier.size(width = 325.dp, height = 665.dp), shape = RoundedCornerShape(SMALL_PADDING)
    ) {


    }
}

@Preview
@Composable
fun CardScreenPreview() {
    CardScreen()
}