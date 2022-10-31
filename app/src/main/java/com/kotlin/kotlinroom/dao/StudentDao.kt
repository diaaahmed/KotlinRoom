package com.kotlin.kotlinroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kotlin.kotlinroom.model.Student

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
}