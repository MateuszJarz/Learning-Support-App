package com.example.learningsupportapplication.di

import com.example.learningsupportapplication.data.repository.Repository
import com.example.learningsupportapplication.domain.use_case.UseCase
import com.example.learningsupportapplication.domain.use_case.add_new_pack_with_list_of_cards.AddNewPackWithListOfCards
import com.example.learningsupportapplication.domain.use_case.add_new_study_pack.AddNewStudyPack
import com.example.learningsupportapplication.domain.use_case.get_all_study_pack.GetAllStudyPack
import com.example.learningsupportapplication.domain.use_case.get_study_card.GetStudyCard
import com.example.learningsupportapplication.domain.use_case.get_study_cards_by_study_pack_id.GetStudyCardsByStudyPackId
import com.example.learningsupportapplication.domain.use_case.get_study_pack_by_id.GetStudyPackById
import com.example.learningsupportapplication.domain.use_case.update_card.UpdateCard
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCase {
        return UseCase(
            addNewPackWithListOfCards = AddNewPackWithListOfCards(repository = repository),
            addNewStudyPack = AddNewStudyPack(repository = repository),
            getStudyPackById = GetStudyPackById(repository = repository),
            getStudyCardsByStudyPackId = GetStudyCardsByStudyPackId(repository = repository),
            getAllStudyPack = GetAllStudyPack(repository = repository),
            getStudyCard = GetStudyCard(repository = repository),
            updateCard = UpdateCard(repository = repository)
        )
    }
}