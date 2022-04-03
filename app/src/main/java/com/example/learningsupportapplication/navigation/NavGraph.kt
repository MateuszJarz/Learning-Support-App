package com.example.learningsupportapplication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.learningsupportapplication.Constants.STUDY_PACK_ARGUMENT_KEY
import com.example.learningsupportapplication.presentation.screen.add_new_card.AddNewStudyCard
import com.example.learningsupportapplication.presentation.screen.create_study_pack.CreateStudyPack
import com.example.learningsupportapplication.presentation.screen.home.HomeScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Splash.route) {

        }
        composable(route = Screen.Welcome.route) {

        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        // Education Process
        composable(
            route = Screen.EducationProcess.route,
            arguments = listOf(navArgument(STUDY_PACK_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }

        // Create Process
        composable(
            route = Screen.CreateStudyPack.route

        ) {
            CreateStudyPack(navController = navController)
        }

        composable(
            route = Screen.AddNewStudyCard.route,
            arguments = listOf(navArgument(STUDY_PACK_ARGUMENT_KEY) {
                type = NavType.IntType
            })

        ) {
            AddNewStudyCard(navController = navController)
        }
        // Edit Process
        composable(
            route = Screen.EditStudyPack.route,
            arguments = listOf(navArgument(STUDY_PACK_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
    }
}



