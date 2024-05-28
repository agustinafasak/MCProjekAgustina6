package com.example.mcprojekagustina

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (var mContext: Context, var kerajaanList:List<Image>):
    RecyclerView.Adapter<MyAdapter.ListViewHolder>() {

        inner class ListViewHolder(var v: View): RecyclerView.ViewHolder(v){
           val imgT = v.findViewById<ImageView>(R.id.imagekerajaan)
           val nameT = v.findViewById<TextView>(R.id.imagetitle)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var v = inflater.inflate(R.layout.data_item,parent,false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int =kerajaanList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = kerajaanList[position]
        holder.nameT.text = newList.name
        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener {

            val name = newList.name
            val descrip = newList.description
            val imgUri = newList.imageUrl

            val mIntent = Intent(mContext, DetailActivity::class.java)
            mIntent.putExtra("NAMET",name)
            mIntent.putExtra("DESCRIT",descrip)
            mIntent.putExtra("IMGURI",imgUri)
            mContext.startActivity(mIntent)
        }
    }
}
