package com.example.doubao.model

/** The data class for an individual memory, containing a string description of memory and a photo. */
data class DoubaoMemory(
  // The description of a memory.
  val description: String,
  // The ResId of doubao photos.
  val photoResId: Int,
)
