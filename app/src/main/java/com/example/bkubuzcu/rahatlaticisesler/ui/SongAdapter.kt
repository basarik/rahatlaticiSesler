package com.example.bkubuzcu.rahatlaticisesler.ui

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
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

        holder.ivPlay.background = if (song.isPlay) getPauseIcon(holder) else getPlayIcon(holder)
        holder.ivFavourite.background = if (song.isFavourite) getFavouriteIcon(holder) else getUnFavouriteIcon(holder)

        holder.ivPlay.setOnClickListener({
            holder.ivPlay.background = if (!song.isPlay) getPauseIcon(holder) else getPlayIcon(holder)
            song.isPlay = !song.isPlay
            listener.onPlayClick(song)
        })

        holder.ivFavourite.setOnClickListener({
            holder.ivFavourite.background = if (!song.isFavourite) getFavouriteIcon(holder) else getUnFavouriteIcon(holder)
            song.isFavourite = !song.isFavourite
            listener.onFavouriteClick(song)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tvMain
        val ivPlay: ImageView = view.ivPlay
        val ivFavourite: ImageView = view.ivFavourite
    }

    private fun getPauseIcon(holder: ViewHolder): Drawable? {
        return ContextCompat.getDrawable(holder.itemView.context,R.drawable.baseline_pause_black_36)
    }

    private fun getPlayIcon(holder: ViewHolder): Drawable? {
        return ContextCompat.getDrawable(holder.itemView.context, R.drawable.baseline_play_arrow_black_36)
    }

    private fun getFavouriteIcon(holder: ViewHolder): Drawable? {
        return ContextCompat.getDrawable(holder.itemView.context,R.drawable.baseline_favorite_black_36)
    }

    private fun getUnFavouriteIcon(holder: ViewHolder): Drawable? {
        return ContextCompat.getDrawable(holder.itemView.context, R.drawable.baseline_favorite_border_black_36)
    }
}

interface OnItemClickListener {
    fun onPlayClick(song: Song)
    fun onFavouriteClick(song: Song)
}