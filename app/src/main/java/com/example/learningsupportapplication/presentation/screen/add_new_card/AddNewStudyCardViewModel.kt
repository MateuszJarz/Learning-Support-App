package com.example.learningsupportapplication.presentation.screen.add_new_card

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.Constants.STUDY_PACK_ARGUMENT_KEY
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.model.StudyPackRelation
import com.example.learningsupportapplication.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddNewStudyCardViewModel @Inject constructor(
    private val useCase: UseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _createdPack: MutableStateFlow<StudyPack?> = MutableStateFlow(null)
    // val createdPack: StateFlow<StudyPack?> = _createdPack

    private val _studyCardPageOneText = mutableStateOf("")
    val studyCardPageOneText = _studyCardPageOneText

    private val _studyCardPageTwoText = mutableStateOf("")
    val studyCardPageTwoText = _studyCardPageTwoText


    var currentList = mutableListOf<StudyCard>()


    init {
        viewModelScope.launch(Dispatchers.IO) {

            val studyPackId = savedStateHandle.get<Int>(STUDY_PACK_ARGUMENT_KEY)
            _createdPack.value = studyPackId?.let { useCase.getStudyPackById(it) }
            _createdPack.value?.id.let { Log.d("_createdPack", it.toString()) }
        }

    }

    fun insertCardToCurrentList(firstPage: String, secondPage: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val studyCard = StudyCard(
                id = 0,
                idStudyPack = 0,
                firstPage = firstPage,
                secondPage = secondPage
            )
            currentList.add(studyCard)

        }
    }

    fun insertCardsToDataBase() {
        viewModelScope.launch(Dispatchers.IO) {

            val studyPackRelation =
                _createdPack.value?.let {
                    StudyPackRelation(
                        studyPack = it,
                        studyCard = currentList
                    )
                }

            if (studyPackRelation != null) {
                useCase.addNewPackWithListOfCards(studyPackRelation = studyPackRelation)
            }
        }
    }

}