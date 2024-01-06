package com.example.doubao.model

import com.example.doubao.R

/** The model holding all Doubao Memories. */
class FakeModel {
  /** Return a list of DoubaoMemory. */
  fun loadDoubaoMemories(): List<DoubaoMemory> {
    return listOf(
      DoubaoMemory("豆豆抬头喵喵叫", R.drawable.doubao_meow),
      DoubaoMemory("豆包睡在衣柜里", R.drawable.doubao_in_wardrobe),
      DoubaoMemory("豆包在猫猫床上", R.drawable.doubao_on_bed),
      DoubaoMemory("豆包吃花花", R.drawable.doubao_eat_flower),
      DoubaoMemory("小时候的小豆豆", R.drawable.doubao_little_doubao),
    )
  }
}