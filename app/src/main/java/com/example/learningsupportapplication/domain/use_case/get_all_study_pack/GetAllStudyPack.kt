package com.example.learningsupportapplication.domain.use_case.get_all_study_pack

import androidx.lifecycle.LiveData
import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyCard
import com.example.learningsupportapplication.domain.model.StudyPack
import kotlinx.coroutines.flow.Flow

class GetAllStudyPack(
    private val repository: Repository
) {
    operator fun invoke(): Flow<List<StudyPack>> {
        return repository.getAllStudyPack()
    }
}