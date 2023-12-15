package com.example.doubao.ui.gallery

import androidx.lifecycle.ViewModel

class GalleryViewModel: ViewModel() {
  private var _description = "豆豆喵喵叫"

  val description: String
    get() = _description
}