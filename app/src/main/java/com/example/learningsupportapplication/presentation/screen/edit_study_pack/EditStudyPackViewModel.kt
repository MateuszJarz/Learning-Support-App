package com.example.learningsupportapplication.presentation.screen.edit_study_pack

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningsupportapplication.data.repository.Repository
import com.example.util.Constants.STUDY_PACK_ARGUMENT_KEY
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.use_case.UseCase
import com.example.util.Constants.STUDY_PACK_EDIT_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditStudyPackViewModel @Inject constructor(
  private val repository: Repository,
    useCase: UseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _currentList = MutableStateFlow<List<StudyCard>>(emptyList())
    val currentList : StateFlow<List<StudyCard>> = _currentList



    init {

        viewModelScope.launch {
            val studyPackId = savedStateHandle.get<Int>(STUDY_PACK_EDIT_ARGUMENT_KEY)!!

            _currentList.value = studyPackId.let { useCase.getStudyCardsByStudyPackId(studyPackId) }
        }

    }

    fun deleteStudyCard(studyCard: StudyCard){
        viewModelScope.launch {
            repository.deleteStudyCard(studyCard = studyCard)
        }

    }
}