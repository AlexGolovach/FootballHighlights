package com.renovavision.footballhighlights.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.renovavision.footballhighlights.R
import com.renovavision.footballhighlights.data.Match
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_highlight.view.*

class HighlightAdapter(private val callback: (String) -> Unit) :
    ListAdapter<Match, HighlightAdapter.HighlightViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HighlightViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view_highlight, parent, false)

        return HighlightViewHolder(view)
    }

    override fun onBindViewHolder(holder: HighlightViewHolder, position: Int) {
        holder.onBind(currentList[position])
    }

    inner class HighlightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(item: Match) {
            Picasso.get()
                .load(item.thumbnail)
                .into(itemView.poster)

            itemView.poster.setOnClickListener {
                callback.invoke(item.videos[0].embed)
            }
        }
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Match>() {
            override fun areItemsTheSame(oldItem: Match, newItem: Match) =
                oldItem.url == newItem.url

            override fun areContentsTheSame(oldItem: Match, newItem: Match) =
                oldItem == newItem
        }
    }
}