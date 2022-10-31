package com.kotlin.kotlinroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.kotlin.kotlinroom.model.Children
import com.kotlin.kotlinroom.model.Director
import com.kotlin.kotlinroom.model.School
import com.kotlin.kotlinroom.model.Student
import com.kotlin.kotlinroom.relation.SchoolAndDirector
import com.kotlin.kotlinroom.relation.SchoolWithChildrens
import com.kotlin.kotlinroom.relation.UserProductCrossRef

@Dao
interface StudentDao
{
    @Query("SELECT * from student_table")
    fun getAll():List<Student>

    @Query("SELECT * from student_table WHERE roll_no LIKE :roll LIMIT 1")
    fun findByRoll(roll:Int):Student

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(student: Student)

    @Delete
    suspend fun delete(student: Student)

    @Query("DELETE FROM student_table")
    suspend fun deleteAll()

    @Query("UPDATE student_table SET first_name=:firstName,last_name=:lastName WHERE roll_no LIKE :roll")
    suspend fun update(firstName:String, lastName:String, roll:Int)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChildren(children: Children)

    @Transaction
    @Query("SELECT * from school WHERE schoolName =:schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * from school WHERE schoolName =:schoolName")
    suspend fun getSchoolWithChildrens(schoolName: String): List<SchoolWithChildrens>

    @Transaction
    @Query("SELECT * from user WHERE userName =:userName")
    suspend fun getProductsWithUser(userName: String): List<UserProductCrossRef>

    @Transaction
    @Query("SELECT * from user WHERE userName =:userName")
    suspend fun getUserWithProducts(userName: String): List<UserProductCrossRef>



}