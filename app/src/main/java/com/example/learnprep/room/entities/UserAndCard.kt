package com.example.learnprep.room.entities

import androidx.room.Embedded
import androidx.room.Relation

data class UserAndCard(
    /* this is one-to-one relationship*/
    @Embedded val user: User,
    @Relation(
        parentColumn = "userId",
        entityColumn = "cardId",
    ) val libraryCard: LibraryCard
)