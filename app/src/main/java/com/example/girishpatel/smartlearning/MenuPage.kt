package com.example.girishpatel.smartlearning

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase

class MenuPage : AppCompatActivity() {
    lateinit var editText : EditText
    lateinit var editText2 : EditText
    lateinit var editText3 : EditText
    lateinit var editText4 : EditText
    lateinit var editText12 : EditText
    lateinit var editText13 : EditText

//    lateinit var listView : ListView

    lateinit var lecureList: MutableList<Students>
    lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        //init()
        lecureList = mutableListOf()


        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        editText12 = findViewById(R.id.editText12)
        editText13 = findViewById(R.id.editText13)

        button =findViewById(R.id.button)

        //listView = findViewById(R.id.lvMain)


        button.setOnClickListener {
            saveData()
            Log.d("MainActivity", "Done saving")

        }



    }

    private fun saveData(){
        val subject = editText.text.toString().trim()
        val batch = editText2.text.toString().trim()
        val profEmail = editText3.text.toString().trim()
        val profName =editText4.text.toString().trim()
        val date = editText12.text.toString().trim()
        val time = editText13.text.toString().trim()

        //check for empty shyd
        if(subject.isEmpty())
        {
            editText.error = "Please enter subject name"
            return
        }
        if(batch.isEmpty())
        {
            editText2.error = "Please enter batch name"
            return
        }
        if(profEmail.isEmpty())
        {
            editText3.error = "Please enter professor's email id"
            return
        }
        if(profName.isEmpty())
        {
            editText4.error = "Please enter professor's name"
            return
        }
        if(date.isEmpty())
        {
            editText12.error = "Please enter lecture date"
            return
        }
        if(time.isEmpty())
        {
            editText13.error = "Please enter lecture time"
            return
        }


        val ref = FirebaseDatabase.getInstance().getReference("Lecture")
        val lectureId = ref.push().key.toString()

        val stud = Students(lectureId,subject,batch,profEmail,profName,date,time)
        ref.child(lectureId).setValue(stud).addOnCompleteListener {
            Toast.makeText(applicationContext,"Lecture is successfully scheduled", Toast.LENGTH_LONG).show()
        }

        //val intent = Intent(this, NewForView::class.java)
        //startActivity(intent)

        editText.setText(null)
        editText2.setText(null)
        editText3.setText(null)
        editText4.setText(null)
        editText12.setText(null)
        editText13.setText(null)

        val intent = Intent(this, ViewOneLec()::class.java)
        intent.putExtra("Subject", subject)
        intent.putExtra("Batch", batch)
        intent.putExtra("Prof. Email",profEmail)
        intent.putExtra("Prof. Name",profName)
        intent.putExtra("Date",date)
        intent.putExtra("Time",time)

        startActivity(intent)

    }
}