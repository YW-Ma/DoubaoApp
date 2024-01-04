package com.example.doubao.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.doubao.R
import com.example.doubao.databinding.FragmentListBinding
import com.example.doubao.model.FakeModel

/**
 * The Fragment that shows a list of doubao memory.
 * This fragment using the recycler view to support the list of memory.
 */
class ListFragment : Fragment() {
  private lateinit var binding: FragmentListBinding
  private val fakeModel = FakeModel() // TODO: update to using viewModel

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View? {
    binding = FragmentListBinding.inflate(inflater, container, false)
    binding.recyclerView.apply {
      adapter = MemoryAdapter(requireContext(), fakeModel.loadDoubaoMemories())
      // Use this setting to improve performance if you know that changes in content do not change
      // the layout size of the Recycler View
      setHasFixedSize(true)
    }
    return binding.root
  }
}