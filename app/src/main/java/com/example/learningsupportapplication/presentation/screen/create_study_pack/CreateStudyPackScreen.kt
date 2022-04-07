package com.example.learningsupportapplication.presentation.screen.create_study_pack

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import kotlinx.coroutines.launch


@Composable
fun CreateStudyPack(
    navController: NavHostController,
    createStudyPackViewModel: CreateStudyPackViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    var studyPackName by createStudyPackViewModel.studyPackName
    val studyPackId = createStudyPackViewModel.studyPackId.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    CreateStudyPackItems(
        studyPackName = studyPackName,
        onValueChange = { text ->
            studyPackName = text
        },
        onClickButton = {

            if (it != "") {

                Log.d("StudyPackName", it)
                coroutineScope.launch {
                    createStudyPackViewModel.insertStudyPackToDataBase()
                    navController.navigate(Screen.AddNewStudyCard.passStudyPackId(studyPackId = studyPackId.value))
                }

            } else {
                Toast.makeText(context, "Wprowadz nazwe pakietu", Toast.LENGTH_SHORT).show()
            }

        })
}

@Composable
fun CreateStudyPackItems(
    studyPackName: String,
    onValueChange: (String) -> Unit,
    onClickButton: (String) -> Unit,
) {


    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(LARGE_PADDING),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = "Name"
            )

            OutlinedTextField(
                modifier = Modifier
                    .width(322.dp)
                    .height(96.dp),
                value = studyPackName,
                shape = RoundedCornerShape(SMALL_PADDING),
                onValueChange = {
                    onValueChange(it)
                },
                placeholder = {
                    Text(
                        text = "Package name: ",
                        textAlign = TextAlign.Center
                    )
                }
            )

            Button(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                shape = RoundedCornerShape(SMALL_PADDING),
                border = BorderStroke(BORDER_SIZE, Color.Black),
                onClick = {
                    onClickButton(studyPackName)
                }
            ) {
                Text(
                    text = "NEXT",
                    color = Color.Black
                )
            }
        }
    }

}


@Preview
@Composable
fun CreateStudyPackItemsPreview() {
    CreateStudyPackItems("", onValueChange = {}, onClickButton = {})
}
