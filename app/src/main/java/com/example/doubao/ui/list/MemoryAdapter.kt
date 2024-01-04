package com.example.doubao.ui.list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.doubao.R
import com.example.doubao.model.DoubaoMemory

class MemoryAdapter(
  private val context: Context,
  private val dataset: List<DoubaoMemory>,
) : RecyclerView.Adapter<MemoryAdapter.MemoryHolder>() { // Specify view holder type in <>

  // Part 1: view holder
  class MemoryHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.memory_description)
    val photoHolder: TextView = view.findViewById(R.id.holder_for_memory_photo)
  }

  // Part 2: three necessary methods
  override fun onCreateViewHolder(
    /* recycler view */ parent: ViewGroup,
    /* specify which type of item view*/ viewType: Int,
  ): MemoryHolder {
    val adapterLayout = LayoutInflater.from(parent.context)
      .inflate(R.layout.list_memory_item, parent, false) // Inflate the actual item view
    return MemoryHolder(adapterLayout) // return a view holder (that knows actual item view)
  }

  override fun getItemCount() = dataset.count()

  override fun onBindViewHolder(holder: MemoryHolder, position: Int) {
    val memoryItem = dataset[position]
    holder.textView.text = memoryItem.description
    // holder.textView.text = context.resources.getString(memoryItem.description) //TODO: update the description into descriptionId
    Log.d("MemoryHolder", "textView text: ${memoryItem.description}")
    holder.photoHolder.text = "Photo Holder" //TODO: update the photo holder into photo id/url.
  }
}