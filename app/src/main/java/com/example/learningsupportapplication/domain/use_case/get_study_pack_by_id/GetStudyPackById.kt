package com.example.learningsupportapplication.domain.use_case.get_study_pack_by_id

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyPack

class GetStudyPackById(
    private val repository: Repository
) {

    suspend operator fun invoke(idStudyPack: Int): StudyPack {
        return repository.getStudyPackById(idStudyPack = idStudyPack)
    }
}