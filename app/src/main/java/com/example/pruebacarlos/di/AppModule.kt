package com.example.pruebacarlos.di

import android.content.Context
import androidx.room.Room
import com.example.pruebacarlos.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomInstance(@ApplicationContext context: Context) = Room.databaseBuilder(
        context.applicationContext, AppDatabase::class.java, "movie_table"
    ).build()

    @Singleton
    @Provides
    fun provideTragosDao(db: AppDatabase) = db.movieDao()

}