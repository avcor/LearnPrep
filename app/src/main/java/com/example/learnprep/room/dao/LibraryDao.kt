package com.example.learnprep.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.learnprep.room.entities.LibraryCard

@Dao
interface LibraryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLibraryCardList(list: List<LibraryCard>)
}