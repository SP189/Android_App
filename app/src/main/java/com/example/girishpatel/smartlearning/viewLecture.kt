package com.example.girishpatel.smartlearning

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.google.firebase.database.FirebaseDatabase

class viewLecture(val mCtx : Context,val layoutResId : Int, val lecList:List<Students> )
    : ArrayAdapter<Students>(mCtx,layoutResId,lecList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //return super.getView(position, convertView, parent)
        val layoutInflator = LayoutInflater.from(mCtx)
        val view = layoutInflator.inflate(layoutResId, null)

        val textView = view.findViewById<TextView>(R.id.textView17)
        val textViewClass = view.findViewById<TextView>(R.id.textView18)
        val textViewEmail = view.findViewById<TextView>(R.id.textView19)
        val textViewProfName = view.findViewById<TextView>(R.id.textView20)
        val textViewDate = view.findViewById<TextView>(R.id.textView21)
        val textViewTime = view.findViewById<TextView>(R.id.textView22)

        val buttonUpdate = view.findViewById<Button>(R.id.button12)

        val buttonDelete = view.findViewById<Button>(R.id.button13)

        val lec = lecList[position]


        textView.text = lec.subjectName
        textViewClass.text = lec.batchName
        textViewEmail.text = lec.profEmail
        textViewProfName.text = lec.profName
        textViewDate.text = lec.date
        textViewTime.text = lec.time

        buttonUpdate.setOnClickListener {
            showUpdateDialogue(lec)
        }

        buttonDelete.setOnClickListener {
            deleteLecture(lec.id)
        }

        return view
    }

    fun deleteLecture(lec_id : String)
    {
        val dbLec = FirebaseDatabase.getInstance().getReference("Lecture").child(lec_id)
        dbLec.removeValue()
        Toast.makeText(mCtx,"Lecture is successfully Cancelled", Toast.LENGTH_LONG).show()

    }

    fun showUpdateDialogue(lec: Students) {
        val builder = AlertDialog.Builder(mCtx)
        builder.setTitle("Update Timetable")

        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.update_values, null)

        val editTextDate = view.findViewById<EditText>(R.id.editText20)
        val editTextTime = view.findViewById<EditText>(R.id.editText21)

        editTextDate.setText(lec.date)
        editTextTime.setText(lec.time)

        builder.setView(view)

        builder.setPositiveButton("Update") { p0, p1 ->
            val dbLec = FirebaseDatabase.getInstance().getReference("Lecture")
            val date1 = editTextDate.text.toString().trim()
            val time1 = editTextTime.text.toString().trim()

            if (date1.isEmpty()) {
                editTextDate.error = "Please enter date"
                editTextDate.requestFocus()
                return@setPositiveButton
            }

            val updatedLec = Students(lec.id, lec.subjectName, lec.batchName, lec.profEmail, lec.profName, date1, time1)
            dbLec.child(lec.id).setValue(updatedLec)
            Toast.makeText(mCtx,"Lecture is successfully Re-scheduled", Toast.LENGTH_LONG).show()

        }
        builder.setNegativeButton("No") { p0, p1 ->

        }

        val alert = builder.create()
        alert.show()

    }
}