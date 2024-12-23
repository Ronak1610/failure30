package com.example.failure30.di

import android.content.Context
import androidx.room.Room
import com.example.failure30.R
import com.example.failure30.data.dao.BookDao
import com.example.failure30.data.network.BookDb
import com.example.failure30.data.repository.BookRepositoryImpl
import com.example.failure30.domain.Repository.BookRepository


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideBookDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        BookDb::class.java,
        context.resources.getString(R.string.db_name)
    ).build()

    @Provides
    fun provideBookDao(
        bookDb: BookDb
    ) = bookDb.bookDao

    @Provides
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository = BookRepositoryImpl(
        bookDao = bookDao
    )
}