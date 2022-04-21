package com.example.learningsupportapplication.presentation.screen.education_process

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.use_case.UseCase
import com.example.learningsupportapplication.util.Constants.STUDY_PACK_ARGUMENT_KEY_EDU
import com.example.learningsupportapplication.util.LearningCardState
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


    val learningCardState: MutableState<LearningCardState> =
        mutableStateOf(LearningCardState.ON_QUESTION)


    private val _studyCards: MutableStateFlow<MutableList<StudyCard>?> =
        MutableStateFlow(mutableListOf())
    val studyCards: StateFlow<MutableList<StudyCard>?> = _studyCards


    init {
        val studyPackId = savedStateHandle.get<Int>(STUDY_PACK_ARGUMENT_KEY_EDU)
        viewModelScope.launch(Dispatchers.IO) {

            _studyCards.value = studyPackId?.let { useCase.getStudyCardsByStudyPackId(it) }
            _studyCards.value?.size.let {
                Log.d("_studyCards: size", it.toString())
            }

        }

    }


}




