package com.example.doubao.model

/** The model holding all Doubao Memories. */
class FakeModel {
  /** Return a list of DoubaoMemory. */
  fun loadDoubaoMemories(): List<DoubaoMemory> {
    return listOf(
      DoubaoMemory("豆豆抬头喵喵叫"),
      DoubaoMemory("豆包睡在衣柜里"),
      DoubaoMemory("豆包在猫猫床上"),
      DoubaoMemory("豆包站起来试图抓花环"),
      DoubaoMemory("小时候的小豆豆")
    )
  }
}