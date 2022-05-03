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


    val id: MutableState<Int> = mutableStateOf(0)
    val idStudyPack: MutableState<Int> = mutableStateOf(0)
    val firstPage: MutableState<String> = mutableStateOf("")
    val secondPage: MutableState<String> = mutableStateOf("")
    val image : MutableState<Bitmap?> = mutableStateOf(null)

    private  var _studyCard: MutableStateFlow<StudyCard> =
        MutableStateFlow(StudyCard(id = 0, 0, "", "", null))

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
    fun updateTaskFields(card: StudyCard) {
        if (card != null) {
            id.value = card.id
            idStudyPack.value = card.idStudyPack
            firstPage.value = card.firstPage
            secondPage.value = card.secondPage
            image.value = card.image
        } else {
            id.value = 0
            idStudyPack.value = 0
            firstPage.value = ""
            secondPage.value = ""
            image.value = null

        }

    }

    fun updateStudyCard() {
        viewModelScope.launch {
            val card = StudyCard(
                id = id.value,
                idStudyPack = idStudyPack.value,
                firstPage = firstPage.value,
                secondPage = secondPage.value,
                image = image.value
            )

            useCase.updateCard(studyCard = card)
        }
    }
}