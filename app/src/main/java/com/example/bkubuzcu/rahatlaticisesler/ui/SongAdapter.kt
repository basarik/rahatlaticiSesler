package com.example.bkubuzcu.rahatlaticisesler.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.model.Song
import kotlinx.android.synthetic.main.row_song.view.*

/**
 * Created by bkubuzcu on 26/09/18.
 */
class SongAdapter(private val list: List<Song>, private val listener: OnItemClickListener) : RecyclerView.Adapter<SongAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val song = list[position]
        holder.title.text = song.title
        holder.itemView.setOnClickListener({
            listener.onItemClick(song)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tvMain
    }

}

interface OnItemClickListener{
    fun onItemClick(song: Song)
}