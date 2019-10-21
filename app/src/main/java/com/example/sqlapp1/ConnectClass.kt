package com.example.sqlapp1

import android.os.StrictMode
import android.util.Log
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConnectClass {
    private  val ip = "192.168.1.101"
    private  val db = "ctm_my"
    private  val user = "sa"
    private  val pass = "admin123"

    fun dbCon() : Connection? {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
        StrictMode.setThreadPolicy(policy)
        var conn : Connection? = null
        var connString : String? = null
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver")
            connString = "jdbc:jtds:sqlserver://$ip;databaseName=$db;user=$user;password=$pass;"
            conn = DriverManager.getConnection(connString)

        }catch (ex : SQLException){
            Log.e("Error : ",ex.message)
        }catch (exl : ClassNotFoundException){
            Log.e("Error : ",exl.message)
        }catch (ex2 : Exception){
            Log.e("Error : ",ex2.message)
        }
        return  conn
    }
}