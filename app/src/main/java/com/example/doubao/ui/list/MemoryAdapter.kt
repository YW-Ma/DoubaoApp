package com.example.doubao.ui.list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.doubao.R
import com.example.doubao.model.DoubaoMemory

// TODO: safeargs传参和recycler view的click listener 参考 https://docs.google.com/document/d/12PRhp0sSCrGRh4FrD4nyftezMnzpdjvMFJiR8LijeHs/edit#bookmark=kix.wlmz8jtzqwdr

class MemoryAdapter(
  private val context: Context,
  private val dataset: List<DoubaoMemory>,
) : RecyclerView.Adapter<MemoryAdapter.MemoryHolder>() { // Specify view holder type in <>

  // Part 1: view holder
  class MemoryHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val textView: TextView = view.findViewById(R.id.memory_description)
    val imageView: ImageView = view.findViewById(R.id.memory_photo)
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
    holder.imageView.setImageResource(memoryItem.photoResId)
    holder.itemView.setOnClickListener{
      Log.d("dev test", "click the position $position")
      it.findNavController().navigate(R.id.action_listFragment_to_galleryFragment)
      // TODO: pass argument so as to navigate to specified memory using SafeArgs.
    }
  }
}