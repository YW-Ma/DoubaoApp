package com.example.doubao.ui.gallery

import android.annotation.SuppressLint
import android.graphics.PointF
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.doubao.databinding.FragmentGalleryBinding

/**
 * The fragment showing a doubao photo with a description.
 */
class GalleryFragment : Fragment() {

  private lateinit var binding: FragmentGalleryBinding
  private val startTouch = PointF()
  private val viewModel: GalleryViewModel by viewModels() // Note: Use Kotlin property delegation. The delegate class viewModels retains viewModel value through configuration changes, so no new viewModel object will be created.
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    touchSlop = (resources.displayMetrics.heightPixels * TOUCH_SLOP_RATIO).toInt()
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View {
    // Inflate the layout for this fragment
    binding = FragmentGalleryBinding.inflate(inflater, container, false)
    // return inflater.inflate(R.layout.fragment_gallery, container, false)
    return binding.root
  }

  @SuppressLint("ClickableViewAccessibility") // Don't care about click.
  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    binding.galleryFragment.rootView.setOnTouchListener { _, event ->
      horizontalSwipeHandler(event)
    }
    updateDescription()
  }

  private fun horizontalSwipeHandler(event: MotionEvent): Boolean {
    when (event.actionMasked) {
      MotionEvent.ACTION_DOWN -> {
        startTouch.set(event.x, event.y)
        return true
      }

      MotionEvent.ACTION_UP -> {
        if (event.x - startTouch.x > touchSlop) {
          // Swipe left
          binding.description.text = viewModel.prevMemory().description
          return true
        } else if (startTouch.x - event.x > touchSlop) {
          // Swipe right
          binding.description.text = viewModel.nextMemory().description
          return true
        }
      }
    }
    return false
  }

  private fun updateDescription() {
    binding.description.text = viewModel.currentMemory.description
  }

  private companion object {
    const val TOUCH_SLOP_RATIO = 0.02f
    var touchSlop = Int.MAX_VALUE
  }
}