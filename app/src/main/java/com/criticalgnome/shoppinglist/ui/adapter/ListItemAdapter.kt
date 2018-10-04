package com.criticalgnome.shoppinglist.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.criticalgnome.shoppinglist.R
import com.criticalgnome.shoppinglist.model.ListItem
import kotlinx.android.synthetic.main.list_item.view.*

class ListItemAdapter(private val items: List<ListItem>) : RecyclerView.Adapter<ListItemAdapter.ListItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ListItemHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    override fun onBindViewHolder(holder: ListItemHolder, position: Int) =
            holder.bind(items[position])

    override fun getItemCount() = items.size

    inner class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: ListItem): Unit =
                with(itemView) {
                    itemName.text = item.name
                    if (item.description.isNotBlank()) {
                        itemDescription.text = item.description
                    } else {
                        itemDescription.vis = false
                    }
                    if (item.count != 0) {
                        itemCount.text = item.count.toString()
                    } else {
                        itemCount.vis = false
                    }
                    item.category?.color?.let {
                        setBackgroundColor(ContextCompat.getColor(context, it))
                    }
                }
    }

    var View.vis
        get() = this.visibility == View.VISIBLE
        set(isVisible) {
            this.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
}
