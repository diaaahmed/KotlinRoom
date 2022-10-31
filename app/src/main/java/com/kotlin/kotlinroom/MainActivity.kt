package com.kotlin.kotlinroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kotlin.kotlinroom.database.AppDatabase
import com.kotlin.kotlinroom.databinding.ActivityMainBinding
import com.kotlin.kotlinroom.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val ui by lazy{
        ActivityMainBinding.inflate(layoutInflater)
    }

    lateinit var appDb:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)

        appDb = AppDatabase.getDatabase(this)
    }

    fun writeData()
    {
        val student = Student(null,"Diaa","Ahmed",1)
        GlobalScope.launch(Dispatchers.IO)
        {

            appDb.studentDao().insert(student)
        }

        Toast.makeText(this@MainActivity, "Done", Toast.LENGTH_SHORT).show()

    }

    fun readData()
    {
        lateinit var student: Student

        GlobalScope.launch {
            student = appDb.studentDao().findByRoll(1)
        }
    }

    fun updateData()
    {
        GlobalScope.launch(Dispatchers.IO) {
            appDb.studentDao().update("Ahmed","Mohamed",1)
        }
    }

    fun deleteAllData()
    {
        GlobalScope.launch(Dispatchers.IO) {

            appDb.studentDao().deleteAll()
        }
    }
}