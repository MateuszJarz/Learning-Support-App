package com.example.learningsupportapplication.presentation.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.common.HandleStudyPackList


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

    val studyPackages by homeScreenViewModel.getAllStudyPack.collectAsState()
    val coroutineScope = rememberCoroutineScope()

    val fabShape = CutCornerShape(
        topStart = 50.dp,
        topEnd = 50.dp,
        bottomEnd = 50.dp,
        bottomStart = 50.dp
    )



    Scaffold(
        backgroundColor = MaterialTheme.colors.background,
        topBar = {
            HomeTopBar(
                navController = navController,
                onDeleteAllConfirmed = {
                    //TODO Confirmed
                    homeScreenViewModel.deleteAllPackage()
                }
            )

        }, content = {
            HandleStudyPackList(
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

