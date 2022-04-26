package com.example.learningsupportapplication.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyPack
import com.example.learningsupportapplication.domain.use_case.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: Repository,
    useCase: UseCase
) : ViewModel() {

    private var _getAllStudyPack  = MutableStateFlow<List<StudyPack>>(emptyList())
    var getAllStudyPack: StateFlow<List<StudyPack>> = _getAllStudyPack


    init {

        viewModelScope.launch(Dispatchers.IO) {
                repository.getAllStudyPack().collect(){ allPackage ->
                    _getAllStudyPack.value = allPackage
                }

        }


    }

    fun deleteAllPackage() {
        viewModelScope.launch {
            repository.deleteAllPackage()
        }
    }
}