package com.kotlin.kotlinroom.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kotlin.kotlinroom.model.Product
import com.kotlin.kotlinroom.model.User

class UserWithProducts(
    @Embedded val user: User,
    @Relation(
        parentColumn = "userName",
        entityColumn = "productName",
        associateBy = Junction(UserProductCrossRef::class)
    )
    val product:List<Product>
)
