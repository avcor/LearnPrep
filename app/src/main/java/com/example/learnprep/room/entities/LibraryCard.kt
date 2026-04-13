package com.example.learnprep.room.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index("userOwnerId", unique = true)]
)
data class LibraryCard(
    @PrimaryKey(autoGenerate = true)
    val cardId: Long,
    val userOwnerId: Long
)
