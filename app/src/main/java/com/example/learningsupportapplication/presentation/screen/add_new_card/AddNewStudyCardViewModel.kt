package com.example.learningsupportapplication.presentation.screen.add_new_card

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.Constants.STUDY_PACK_ARGUMENT_NAME
import com.example.learningsupportapplication.domain.model.StudyCard
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AddNewStudyCardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

     private val _studyCardPageOneText = mutableStateOf("")
     val studyCardPageOneText = _studyCardPageOneText

    private val _studyCardPageTwoText = mutableStateOf("")
    val studyCardPageTwoText = _studyCardPageOneText

    private lateinit var _studyPackName: String
    private var currentList = mutableListOf<StudyCard>()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val studyPackName = savedStateHandle.get<String>(STUDY_PACK_ARGUMENT_NAME)

            if (studyPackName != null) {
                _studyPackName = studyPackName
            }
        }
    }

     fun insertCardToCurrentList(firstPage: String, secondPage: String){
        viewModelScope.launch(Dispatchers.IO){
            val studyCard = StudyCard(
                id = 0,
                idStudyPack = 0,
                firstPage = firstPage,
                secondPage = secondPage
            )
            currentList.add(studyCard)
            Log.d("currentList",currentList.size.toString())
            Log.d("currentList",currentList[0].firstPage)
        }

    }
     fun insertCardsToDataBase(studyCard: MutableList<StudyCard>){
        viewModelScope.launch(Dispatchers.IO){

        }
    }
}