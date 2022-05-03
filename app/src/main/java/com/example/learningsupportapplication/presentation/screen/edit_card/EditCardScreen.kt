package com.example.learningsupportapplication.presentation.screen.edit_card

import android.annotation.SuppressLint
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.presentation.common.StudyCardSheet
import com.example.learningsupportapplication.presentation.screen.add_new_card.AddNewStudyCardViewModel
import com.example.util.Constants

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun EditStudyCard(
    navController: NavHostController,
    editCardViewModel: EditCardViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val studyCard = editCardViewModel.studyCard

    var firstPage by editCardViewModel.firstPage
    var secondPage by editCardViewModel.secondPage
    val bitmap = editCardViewModel.bitmap
    val imageUri = editCardViewModel.imageUri


    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { _uri ->
            if (_uri != null) {
                imageUri.value = _uri
            }

        }


    imageUri.let {
        var defaultUri = Uri.parse(Constants.DEFAULT_IMAGE_PATH)

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

        }else{
            bitmap.value = studyCard.value.image
        }



    }

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        StudyCardSheet(

            pageOneText = firstPage,
            pageOneTextChange = {text1 ->
                firstPage = text1
            },

            pageTwoText = secondPage,
            pageTwoTextChange = {text2 ->
                secondPage = text2
            },

            bitmap = bitmap.value,

            onClickChoosePhoto = {
                launcher.launch(
                    "image/*"
                )


            },

            onClickAdd = {
                editCardViewModel.updateStudyCard()
                navController.popBackStack()
            },
            onClickCreate = {

            }

        )
    }


}

@Preview
@Composable
fun EditStudyCardPrev() {
    EditStudyCard(
        navController = rememberNavController()
    )
}