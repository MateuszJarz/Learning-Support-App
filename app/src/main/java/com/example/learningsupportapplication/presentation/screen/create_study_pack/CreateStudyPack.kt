package com.example.learningsupportapplication.presentation.screen.create_study_pack

import android.content.Context
import android.os.Message
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.learningsupportapplication.navigation.Screen
import com.example.learningsupportapplication.ui.theme.BORDER_SIZE
import com.example.learningsupportapplication.ui.theme.LARGE_PADDING
import com.example.learningsupportapplication.ui.theme.SMALL_PADDING
import kotlinx.serialization.descriptors.PrimitiveKind


@Composable
fun CreateStudyPack(
    navController: NavHostController,
) {
    val context = LocalContext.current

    CreateStudyPackItems(
        onClick = {
            if (it != ""){
                navController.navigate(Screen.AddNewStudyCard.passStudyPackName(it))
                Log.d("StudyPackName", it)
            }else{
                Toast.makeText(context,"Wprowadz nazwe pakietu",Toast.LENGTH_SHORT).show()
            }

        })
}

@Composable
fun CreateStudyPackItems(
    onClick: (String) -> Unit,
) {

    var studyPackName by remember {
        mutableStateOf(TextFieldValue(""))
    }

    Scaffold(

    ) {
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
                onValueChange = { newText ->
                    studyPackName = newText
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
                    onClick(studyPackName.text)
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
    CreateStudyPackItems(onClick = {})
}
