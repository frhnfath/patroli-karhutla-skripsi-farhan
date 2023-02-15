package com.ilmukomputeripb.patrolikarhutla.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.ilmukomputeripb.patrolikarhutla.R
import com.ilmukomputeripb.patrolikarhutla.data.KamusIstilahData
import com.ilmukomputeripb.patrolikarhutla.view.KamusDetailActivity

class ListKamusAdapter(private val listKamus: ArrayList<KamusIstilahData>) : RecyclerView.Adapter<ListKamusAdapter.ListViewHolder>() {
    private lateinit var dataList: ArrayList<KamusIstilahData>
    class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.kamus_tv_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_kamus, parent, false)
        return ListViewHolder(view)
    }

    fun filterList(filterList: ArrayList<KamusIstilahData>) {
        dataList = filterList
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, description, source) = listKamus[position]
        holder.tvTitle.text = title
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, KamusDetailActivity::class.java)
            intent.putExtra(KamusDetailActivity.EXTRA_DATA, listKamus[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = listKamus.size
}