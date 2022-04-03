package com.example.learningsupportapplication.presentation.screen.education_process

import androidx.lifecycle.*
import com.example.learningsupportapplication.Constants
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EducationProcessViewModel @Inject constructor(
    useCase: UseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _studyPack = MutableLiveData<StudyPack>()
    val studyPack: LiveData<StudyPack> = _studyPack

    init {
        viewModelScope.launch {
            val studyPackId = savedStateHandle.get<Int>(Constants.STUDY_PACK_ARGUMENT_KEY)
        }
    }
}