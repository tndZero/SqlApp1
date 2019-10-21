package com.example.sqlapp1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class  UserAdapter (val users: ArrayList<Users>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){
    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {
        val txtUserId = itemView.findViewById(R.id.txtUserID) as TextView
        val txtUserName = itemView.findViewById(R.id.txtUserName) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.lo_user,parent,false)
        return  ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return users.size
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val user : Users = users[position]
        holder?.txtUserId.text = user.UserId.toString()
        holder?.txtUserName.text = user.FirstName.toString()

    }

}