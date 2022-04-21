package com.example.learningsupportapplication.presentation.screen.create_study_pack

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CreateStudyPackViewModel @Inject constructor(
    private val useCase: UseCase,

    ) : ViewModel() {


    private val _studyPackName = mutableStateOf("")
    val studyPackName = _studyPackName

    private var _studyPackId: MutableStateFlow<Int> = MutableStateFlow(0)
    var studyPackId: StateFlow<Int> = _studyPackId


    suspend fun insertStudyPackToDataBase() {

        withContext(viewModelScope.coroutineContext) {

            val studyPack = StudyPack(0, studyPackName.value)
            useCase.addNewStudyPack(studyPack = studyPack).let {
                _studyPackId.value = it.toInt()
            }


        }

    }

}