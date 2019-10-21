package com.example.sqlapp1

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class  UserAdapter (val users: ArrayList<Users>) : RecyclerView.Adapter<UserAdapter.ViewHolder>(){

    class  ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.ViewHolder {
        val txtUsers = itemView.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}