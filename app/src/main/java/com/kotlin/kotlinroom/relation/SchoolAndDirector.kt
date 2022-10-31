package com.kotlin.kotlinroom.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.kotlin.kotlinroom.model.Director
import com.kotlin.kotlinroom.model.School

data class SchoolAndDirector(
    @Embedded val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)