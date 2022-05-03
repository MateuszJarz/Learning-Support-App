package com.example.learningsupportapplication.presentation.screen.education_process

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.use_case.UseCase
import com.example.util.Constants.STUDY_PACK_EDU_ARGUMENT_KEY
import com.example.util.LearningCardState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EducationProcessViewModel @Inject constructor(
    useCase: UseCase,
    savedStateHandle: SavedStateHandle,

    ) : ViewModel() {



    val learningCardState : MutableState<LearningCardState>
    = mutableStateOf(LearningCardState.ON_QUESTION)

    private var _studyCards : MutableStateFlow<MutableList<StudyCard>?> = MutableStateFlow(null)
    val studyCards : StateFlow<MutableList<StudyCard>?> = _studyCards

    /*private val _studyCards: MutableStateFlow<MutableList<StudyCard>?> =
        MutableStateFlow(mutableListOf())
    val studyCards: StateFlow<MutableList<StudyCard>?> = _studyCards*/


    init {

        viewModelScope.launch(Dispatchers.IO) {
            val studyPackId = savedStateHandle.get<Int>(STUDY_PACK_EDU_ARGUMENT_KEY)!!
            _studyCards.value = studyPackId.let { useCase.getStudyCardsByStudyPackId(studyPackId) }

            _studyCards.value!!.size.let {
                Log.d("_studyCards: size", it.toString())
            }

        }

    }


}




