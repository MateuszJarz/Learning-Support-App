package com.example.learningsupportapplication.navigation


sealed class Screen(val route: String) {

    object Splash : Screen(route = "splash_screen")

    object Welcome : Screen(route = "welcome_screen")

    object Home : Screen(route = "home_screen") // Create or select study pack

    // Education Process
    object EducationProcess : Screen(route = "education_process/{studyPackId}") {
        fun passEduPackID(packId: Int): String {
            return "education_process/$packId"
        }
    }

    // Create Process
    object CreateStudyPack : Screen(route = "create_study_pack_screen")


    object AddNewStudyCard : Screen(route = "add_new_study_card_screen/{studyPackName}") {
        fun passStudyPackName(studyPackName: String): String {
            return "add_new_study_card_screen/$studyPackName"
        }
    } // Set name

    // Edit Process
    object EditStudyPack : Screen(route = "edit_study_pack_screen/{studyPackId}")


}