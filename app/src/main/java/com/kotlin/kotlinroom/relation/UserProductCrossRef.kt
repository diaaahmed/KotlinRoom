package com.kotlin.kotlinroom.relation

import androidx.room.Entity

@Entity(primaryKeys = ["userName","productName"])
data class UserProductCrossRef(
    val userName:String,
    val productName:String
)