package com.example.learningsupportapplication.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.common.StudyPackList
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING


/*
    * 1. Field with button to create new StudyPack
    * - button
    * 2. List with all created StudyPack
    * - start button
    * - name of pack
    * - */

@ExperimentalMaterialApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
) {

    val studyPackages = homeScreenViewModel.getAllStudyPack
    val coroutineScope = rememberCoroutineScope()

    val fabShape =  CutCornerShape(
        topStart = 50.dp,
        topEnd = 50.dp,
        bottomEnd = 50.dp,
        bottomStart = 50.dp
    )



    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            HomeTopBar(
                navController = navController
            )

        }, content = {
            StudyPackList(
                studyPackages = studyPackages,
                navController = navController
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.size(70.dp),
                onClick = {
                    navController.navigate(Screen.CreateStudyPack.route)
                },
                shape = fabShape,
                backgroundColor = Color(0xFFFF8C00)
            ) {
                Icon(Icons.Filled.Add, "Add")
            }
        },
        isFloatingActionButtonDocked = true,
        floatingActionButtonPosition = FabPosition.Center,


        bottomBar = {
            AppBottomBar(
                navController = navController,
                shape = fabShape,
                onAddClicked = {
                }
            )
        }
    )


}

