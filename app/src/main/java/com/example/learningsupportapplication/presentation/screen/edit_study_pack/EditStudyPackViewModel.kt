package com.example.learningsupportapplication.presentation.screen.edit_study_pack

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.use_case.UseCase
import com.example.learningsupportapplication.util.Constants.STUDY_PACK_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditStudyPackViewModel @Inject constructor(
    useCase: UseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private var _currentList = mutableStateListOf<StudyCard>()
    val currentList = _currentList

    init {
        val studyPackId = savedStateHandle.get<Int>(STUDY_PACK_ARGUMENT_KEY)
        _currentList =
            studyPackId?.let { useCase.getStudyCardsByStudyPackId(it) } as SnapshotStateList<StudyCard>

    }
}