package com.example.learningsupportapplication.presentation.screen.create_study_pack

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateStudyPackViewModel @Inject constructor(
    private val useCase: UseCase
) : ViewModel() {

    private val _studyPackName = mutableStateOf("")
    val studyPackName = _studyPackName


    fun insertStudyPackToDataBase() {
        viewModelScope.launch(Dispatchers.IO) {
            val studyPack = StudyPack(0, studyPackName.value)

            useCase.addNewStudyPack(studyPack = studyPack)
        }
    }


}