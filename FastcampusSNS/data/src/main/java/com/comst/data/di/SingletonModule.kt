package com.comst.data.di

import android.content.Context
import androidx.room.Room
import com.comst.data.database.BoardDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class SingletonModule {

    companion object{
        @Provides
        fun provideBoardDatabase(context:Context):BoardDatabase{
            return Room.databaseBuilder(
                context,
                BoardDatabase::class.java,
                "BoardDatabase"
            ).build()
        }
    }
}