package com.example.learningsupportapplication.presentation.screen.edit_card

import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.use_case.UseCase
import com.example.util.Constants.STUDY_CARD_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditCardViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val useCase: UseCase
) : ViewModel() {



    val firstPage: MutableState<String> = mutableStateOf("")
    val secondPage: MutableState<String> = mutableStateOf("")


    private  var _studyCard =  MutableStateFlow<StudyCard>(StudyCard(id = 0, 0, "", "", null))

    var studyCard: StateFlow<StudyCard> = _studyCard

    private val _bitmap = mutableStateOf<Bitmap?>(null)
    val bitmap = _bitmap

    private val _imageUri = mutableStateOf<Uri?>(null)
    val imageUri = _imageUri

    init {
        viewModelScope.launch(Dispatchers.IO) {

            val studyCardId = savedStateHandle.get<Int>(STUDY_CARD_ARGUMENT_KEY)!!
            _studyCard.value = useCase.getStudyCard(idStudyCard = studyCardId)


        }
    }

    fun updateStudyCard() {
        viewModelScope.launch {
            val card = StudyCard(
                id = studyCard.value.id,
                idStudyPack = studyCard.value.idStudyPack,
                firstPage = firstPage.value,
                secondPage = secondPage.value,
                image = bitmap.value
            )

            useCase.updateCard(studyCard = card)
        }
    }
}