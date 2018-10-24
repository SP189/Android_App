package com.example.girishpatel.smartlearning

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.buttons2.*


class NewForView : AppCompatActivity()
{
    lateinit var ref : DatabaseReference
    lateinit var listView : ListView
    lateinit var lecureList: MutableList<Students>


    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d("NewForView", "entered on Create")
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        setContentView(R.layout.buttons2)

        lecureList = mutableListOf()

        ref = FirebaseDatabase.getInstance().getReference("Lecture")

        listView = findViewById(R.id.lvMain)


        Log.d("NewForView", "entered on Create 2 ")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0!!.exists())
                {
                    lecureList.clear()

                    for(h in p0.children)
                    {
                        val lec = h.getValue(Students::class.java)
                        lecureList.add(lec!!)
                    }

                   // val adapter = viewLecture(applicationContext, R.layout.view_tt, lecureList)
                    val adapter = viewLecture(this@NewForView, R.layout.view_tt, lecureList)
                    listView.adapter = adapter
                }

            }

        });


    }
}