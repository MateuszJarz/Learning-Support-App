package com.example.learningsupportapplication.presentation.screen.edit_study_pack

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalMaterialApi
@Composable
fun EditStudyPackScreen(
    navController: NavHostController,
    editStudyPackViewModel: EditStudyPackViewModel = hiltViewModel()
) {
    val studyCards by editStudyPackViewModel.currentList.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
            .padding(all =SMALL_PADDING),
        topBar = {
            EditScreenTopBar(navController = navController)
        },

    ){
        EditStudyPackList(
            editStudyPackViewModel = editStudyPackViewModel,
            navController = navController,
            studyCards = studyCards
        )
    }

}


