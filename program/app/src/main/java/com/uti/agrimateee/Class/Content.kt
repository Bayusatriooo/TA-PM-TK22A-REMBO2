package com.uti.agrimateee.Class

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.uti.agrimateee.R

class Content(
    private val contentList: List<Pair<String, String>>, // Pair of title and URL
    private val onItemClick: (String, String) -> Unit // Callback with title and URL
) : RecyclerView.Adapter<Content.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemText: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (title, url) = contentList[position]
        holder.itemText.text = title

        holder.itemView.setOnClickListener {
            onItemClick(title, url)
        }
    }

    override fun getItemCount(): Int {
        return contentList.size
    }
}