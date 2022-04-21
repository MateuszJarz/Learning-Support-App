package com.example.learningsupportapplication.presentation.screen.add_new_card

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.common.StudyCardSheet
import com.example.util.Constants.DEFAULT_IMAGE_PATH


@Composable
fun AddNewStudyCard(
    navController: NavHostController,
    addNewStudyCardViewModel: AddNewStudyCardViewModel = hiltViewModel()

) {
    var studyCardPageOneText by addNewStudyCardViewModel.studyCardPageOneText
    var studyCardPageTwoText by addNewStudyCardViewModel.studyCardPageTwoText

    val context = LocalContext.current

    val bitmap = addNewStudyCardViewModel.bitmap
    val imageUri = addNewStudyCardViewModel.imageUri
    Log.d("imageData", imageUri.toString())
    Log.d("bitmap", bitmap.value.toString())

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { _uri ->

            if (_uri != null) {
                imageUri.value = _uri
            }


        }


    imageUri.let {
        var defaultUri = Uri.parse(DEFAULT_IMAGE_PATH)
        var uri = it.value
        if (uri != null) {

            if (Build.VERSION.SDK_INT < 28) {
                bitmap.value = MediaStore.Images
                    .Media.getBitmap(context.contentResolver, uri)

            } else {
                val source = ImageDecoder
                    .createSource(context.contentResolver, uri)
                bitmap.value = ImageDecoder.decodeBitmap(source)
            }

            /*bitmap?.value?.let { btm ->

            }*/
        }


    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        StudyCardSheet(

            pageOneText = studyCardPageOneText,
            pageOneTextChange = { text1 ->
                studyCardPageOneText = text1
            },

            pageTwoText = studyCardPageTwoText,
            pageTwoTextChange = { text2 ->
                studyCardPageTwoText = text2
            },

            bitmap = bitmap.value,

            onClickChoosePhoto = {
                launcher.launch(
                    "image/*"
                )


            },

            onClickAdd = {
                addNewStudyCardViewModel.insertCardToCurrentList()
            },
            onClickCreate = {
                addNewStudyCardViewModel.insertCardsToDataBase()
                navController.navigate(Screen.Home.route)
            }

        )
    }


}


