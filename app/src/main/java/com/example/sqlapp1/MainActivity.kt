package com.example.sqlapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

   companion object {
       val db = DatabaseHelper()
   }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db.connectionClass = ConnectClass()
    }

    fun UserOnClick(view: View){
        val i = Intent(this, UserActivity::class.java)
        startActivity(i)
    }
}
