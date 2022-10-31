package com.kotlin.kotlinroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Children(
    @PrimaryKey(autoGenerate = false)
    val childrenName:String,
    val schoolName:String,
    val semester:Int
)
