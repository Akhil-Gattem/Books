package com.example.samplebooks.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.samplebooks.R
import com.example.samplebooks.model.Data

class AudioRecyclerViewAdapter(private val dataList: List<Data>) : RecyclerView.Adapter<AudioRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameID: TextView = itemView.findViewById(R.id.name_edit)
        val languageID: TextView = itemView.findViewById(R.id.language_edit)
        val identifierID: TextView = itemView.findViewById(R.id.identifier_edit)
        val formatID: TextView = itemView.findViewById(R.id.format_edit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = dataList[position]
        data.apply {
            holder.itemView.apply {
                holder.nameID.text = data.englishName
                holder.languageID.text = data.language
                holder.identifierID.text = data.identifier
                holder.formatID.text = data.format
            }
        }
    }
}