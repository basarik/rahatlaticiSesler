package com.example.bkubuzcu.rahatlaticisesler.ui.category

import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bkubuzcu.rahatlaticisesler.R
import com.example.bkubuzcu.rahatlaticisesler.model.Category
import kotlinx.android.synthetic.main.row_category.view.*

/**
 * Created by bkubuzcu on 25/09/18.
 * this is CategoryAdapter.
 */

class CategoryAdapter(private val list: List<Category>, private val listener: OnItemClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = list[position]

        holder.title.text = category.title
        holder.category.background = getBackground(holder, category.id)

        holder.itemView.setOnClickListener({
            listener.onItemClick(category)
        })
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.tvMain
        val category:ImageView = view.ivCategory
    }

    /**
     * get background image from drawable
     */
    private fun getBackground(holder: ViewHolder, id:Int) : Drawable{

        var drawable = R.drawable.bird
        when(id){
            0-> drawable = R.drawable.bird
            1-> drawable = R.drawable.piano
            2-> drawable = R.drawable.nature
        }

        return ContextCompat.getDrawable(holder.itemView.context, drawable)!!
    }
}

/**
 * listener of category item
 */
interface OnItemClickListener {
    /**
     * on clicked
     */
    fun onItemClick(category: Category)
}