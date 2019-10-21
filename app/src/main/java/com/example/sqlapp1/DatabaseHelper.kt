package com.example.sqlapp1

import android.app.ProgressDialog
import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.io.PrintWriter
import java.io.StringWriter


class DatabaseHelper {
    lateinit var  ctx:Context

    private var  isDone = false
    private lateinit var  rv : RecyclerView
    private lateinit var  query : String
    private lateinit var  adpter : RecyclerView.Adapter<*>
    private var recordCount : Int = 0
    private var functionType : Int = 0
    private lateinit var records : ArrayList<Any>
    lateinit var connectionClass : ConnectClass

    inner class  SyncData : AsyncTask<String,String,String>() {
        private var message = "No Connection"
        lateinit var prog: ProgressDialog

        override fun doInBackground(vararg params: String?): String {
            try {
                var myConn = connectionClass.dbCon()
                if (myConn == null) {
                    isDone = false
                } else {
                    val statment = myConn!!.createStatement()
                    val cursor = statment.executeQuery(query)
                    if (cursor != null) {
                        while (cursor!!.next()) {
                            try {
                                when (functionType) {
                                    1 -> records.add(
                                        Users(
                                            cursor!!.getInt("UserID"),
                                            cursor!!.getString("FirstName")
                                        )
                                    )
                                }
                                recordCount++
                            } catch (ex: Exception) {
                                ex.printStackTrace()
                            }
                        }
                        message = "Found $recordCount"
                        isDone = true
                    } else {
                        message = "No Record"
                        isDone = false
                    }
                }
            } catch (ex: Exception) {
                ex.printStackTrace()
                val writer = StringWriter()
                ex.printStackTrace(PrintWriter(writer))
                message = writer.toString()
                isDone = false
            }
            return message
        }

        override fun onPostExecute(result: String?) {
           prog.dismiss()
            Toast.makeText(ctx,message,Toast.LENGTH_SHORT).show()
            if (isDone == false){

            }else{
                try {
                    rv.adapter = adpter
                }catch (ex : Exception){

                }
            }
        }
    }

    fun getUsers(rv : RecyclerView){
        this.rv = rv
        query = "select UserId,FirstName from Users"
        records = ArrayList<Users>() as ArrayList<Any>
        adpter = UserAdapter(records as ArrayList<Users>)
        functionType = 1
        SyncData().execute("")
    }
}