package com.kotlin.kotlinroom.model

import androidx.room.Entity
import androidx.room.PrimaryKey

typealias Price = Double
typealias Image = String
typealias ProductName = String

@Entity
data class Product(
    @PrimaryKey(autoGenerate = false)
    val productName:ProductName,
    val price:Price,
    val image:Image
)
