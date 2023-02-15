package com.Poro.listmaker.ui.detail.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Poro.listmaker.databinding.ListItemViewHolderBinding
import com.Poro.listmaker.models.TaskList

class ListItemsRecyclerViewAdapter(
    val list: TaskList
) : RecyclerView.Adapter<ListItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val binding =
            ListItemViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.tasks.size
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.binding.textViewTask.text = list.tasks[position]
    }
}