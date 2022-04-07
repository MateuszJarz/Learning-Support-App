package com.example.learningsupportapplication.domain.use_case.get_study_cards_by_study_pack_id

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.model.StudyCard

class GetStudyCardsByStudyPackId(
    private val repository: Repository
) {
    operator fun invoke(idStudyPack: Int): MutableList<StudyCard> {
        return repository.getStudyCardsByStudyPackId(idStudyPack = idStudyPack)
    }
}