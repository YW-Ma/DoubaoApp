package com.example.doubao.ui.gallery

import androidx.lifecycle.ViewModel
import com.example.doubao.model.DoubaoMemory
import com.example.doubao.model.FakeModel

/**
 * The viewModel supporting the GalleryFragment
 * It keep the information of which memory is showing now and provide functions to show next / prev
 * memory.
 * */
class GalleryViewModel : ViewModel() {
  private val fakeModel: FakeModel = FakeModel()
  private var _id = 0
  private val _doubaoMemories
    get() = fakeModel.loadDoubaoMemories()

  val currentMemory: DoubaoMemory
    get() = _doubaoMemories[_id]

  /** Get next memory. */
  fun nextMemory(): DoubaoMemory {
    _id++
    if (_id >= _doubaoMemories.size) {
      _id = 0
    }
    return _doubaoMemories[_id]
  }

  /** Get previous memory. */
  fun prevMemory(): DoubaoMemory {
    _id--
    if (_id < 0) {
      _id = _doubaoMemories.size - 1
    }
    return _doubaoMemories[_id]
  }
}