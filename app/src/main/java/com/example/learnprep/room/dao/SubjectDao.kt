package com.example.learnprep.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.learnprep.room.entities.Subject
import com.example.learnprep.room.entities.UserSubjectCrossRef

@Dao
interface SubjectDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(list: List<Subject>)

}