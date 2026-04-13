package com.example.learnprep.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User (
    @PrimaryKey(autoGenerate = true)
    val userId: Long,
    val name: String
)

