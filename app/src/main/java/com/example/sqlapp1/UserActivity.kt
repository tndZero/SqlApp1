package com.example.sqlapp1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserActivity : AppCompatActivity() {

    lateinit var  rv : RecyclerView

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)


        rv = findViewById(R.id.rvUser)
        rv.layoutManager = LinearLayoutManager(this,LinearLayout.VERTICAL,false)
        MainActivity.db.ctx = this
        MainActivity.db.getUsers(rv)
    }
}
