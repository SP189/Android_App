package com.example.girishpatel.smartlearning

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.one_lec.*


class ViewOneLec() : AppCompatActivity()
{

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.one_lec)

      var intent = intent
      val subject = intent.getStringExtra("Subject")
      val batch = intent.getStringExtra("Batch")
      val email = intent.getStringExtra("Prof. Email")
      val name = intent.getStringExtra("Prof. Name")
      val date = intent.getStringExtra("Date")
      val time = intent.getStringExtra("Time")


      val textView = findViewById<TextView>(R.id.textView33)
      val textViewClass = findViewById<TextView>(R.id.textView34)
      val textViewEmail = findViewById<TextView>(R.id.textView37)
      val textViewProfName = findViewById<TextView>(R.id.textView38)
      val textViewDate = findViewById<TextView>(R.id.textView39)
      val textViewTime = findViewById<TextView>(R.id.textView40)

      textView.text = "SUBJECT: " + subject
      textViewClass.text = "BATCH: " + batch
      textViewEmail.text = "EMAIL ID: " + email
      textViewProfName.text = "NAME: " + name
      textViewDate.text = "DATE: " + date
      textViewTime.text = "TIME: " + time

      button11.setOnClickListener {
         val intent = Intent(this, MainActivity()::class.java)
         startActivity(intent)


      }
   }





}