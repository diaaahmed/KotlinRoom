package com.kotlin.kotlinroom.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.kotlin.kotlinroom.model.Children
import com.kotlin.kotlinroom.model.School

data class SchoolWithChildrens(
    @Embedded val school:School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val children: List<Children>
)