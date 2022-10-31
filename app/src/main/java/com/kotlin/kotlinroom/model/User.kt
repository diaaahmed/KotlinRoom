package com.kotlin.kotlinroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

typealias UserEmail = String
typealias UserName = String
typealias UserAddress = String

@Entity
data class User(
    @PrimaryKey(autoGenerate = false)
    val userName:UserName,
    val userEmail:UserEmail,
    val userAddress: UserAddress
)
