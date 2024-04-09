package com.example.assignment_putatoe

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView

class adapter(private val listitemss:ArrayList<itemss>):RecyclerView.Adapter<adapter.MyViewHolder>(){
    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val name:TextView = itemView.findViewById(R.id.txt2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listitemss.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTemp = listitemss[position]
        holder.name.text = currentTemp.name
    }

}