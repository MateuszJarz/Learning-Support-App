package com.example.learningsupportapplication.di

import android.content.Context
import androidx.room.Room
import com.example.learningsupportapplication.data.LSADataBase
import com.example.learningsupportapplication.util.Constants.LSA_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {
    @Provides
    @Singleton
    fun provideDataBase(
        @ApplicationContext context: Context
    ): LSADataBase {
        return Room.databaseBuilder(
            context,
            LSADataBase::class.java,
            LSA_DATABASE
        )
            //.fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideStudyCardDao(lsaDataBase: LSADataBase) = lsaDataBase.studyCardDao()

    @Provides
    @Singleton
    fun provideStudyPackDao(lsaDataBase: LSADataBase) = lsaDataBase.studyPackDao()
}

