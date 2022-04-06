package com.example.learningsupportapplication.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    useCase: UseCase
) : ViewModel() {

    var getAllStudyPack: List<StudyPack> = mutableListOf()
    //val getAllStudyPack: List<StudyPack> = _getAllStudyPack


    init {

        viewModelScope.launch(Dispatchers.IO) {
            val _getAllStudyPack = useCase.getAllStudyPack()
            _getAllStudyPack.collect() {
                getAllStudyPack = it
            }
        }


    }
}