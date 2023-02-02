package com.ilmukomputeripb.patrolikarhutla.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.data.KamusIstilahData

class ListKamusAdapter(private val listKamus: ArrayList<KamusIstilahData>) : RecyclerView.Adapter<ListKamusAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.kamus_tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kamus, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, source) = listKamus[position]
        holder.tvTitle.text = title
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "You Choose " + listKamus[holder.adapterPosition].title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listKamus.size
}