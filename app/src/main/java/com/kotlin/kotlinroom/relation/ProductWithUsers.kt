package com.kotlin.kotlinroom.relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.kotlin.kotlinroom.model.Product
import com.kotlin.kotlinroom.model.User

data class ProductWithUsers(
    @Embedded val product:Product,
    @Relation(
        parentColumn = "productName",
        entityColumn = "userName",
        associateBy = Junction(UserProductCrossRef::class)
    )
    val users:List<User>
)
