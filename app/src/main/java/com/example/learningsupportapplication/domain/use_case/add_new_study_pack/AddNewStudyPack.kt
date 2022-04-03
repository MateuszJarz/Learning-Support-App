package com.example.learningsupportapplication.domain.use_case.add_new_study_pack

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyPack

class AddNewStudyPack(
    private val repository: Repository
) {
    suspend operator fun invoke(studyPack: StudyPack): Long {
        return repository.addNewStudyPack(studyPack = studyPack)
    }
}