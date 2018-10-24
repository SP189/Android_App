package com.example.girishpatel.smartlearning

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent

import java.util.jar.Attributes
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
//import jdk.nashorn.internal.runtime.ECMAException.getException
import com.google.firebase.auth.api.internal.zzal
//import org.junit.experimental.results.ResultMatchers.isSuccessful
import com.google.firebase.auth.AuthResult
import com.google.android.gms.tasks.Task
import android.support.annotation.NonNull
import android.support.v4.app.FragmentActivity
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.widget.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.database.*
import kotlin.system.measureTimeMillis
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import com.example.girishpatel.smartlearning.R.id.*


class MainActivity : AppCompatActivity() {

    lateinit var AddLec : Button
    lateinit var ViewLec : Button
    lateinit var delLec : Button
    lateinit var ViewVideo : Button
    //lateinit var BackButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.buttons_page)

        AddLec = findViewById(R.id.button7)
        ViewLec = findViewById(R.id.button3)
        delLec = findViewById(R.id.button4)
        ViewVideo = findViewById(R.id.button5)
        //BackButton = findViewById(R.id.button6)

        AddLec.setOnClickListener {
            val intent = Intent(this, MenuPage::class.java)
            startActivity(intent)
        }

        ViewLec.setOnClickListener {
            val intent = Intent(this, NewForView::class.java)
            startActivity(intent)
        }

        delLec.setOnClickListener {
            val intent = Intent(this, NewForView::class.java)
            startActivity(intent)
        }
        ViewVideo.setOnClickListener {
            val intent = Intent(this, VideoActivity::class.java)
            startActivity(intent)
        }



    }



}
