package com.example.doubao.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doubao.R
import com.example.doubao.databinding.FragmentProfileBinding

/**
 * The entrance of doubao App. Showing doubao photos and buttons to gallery and list.
 */
class ProfileFragment : Fragment() {
  private lateinit var binding: FragmentProfileBinding

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?,
  ): View {
    // Inflate the layout for this fragment
    binding = FragmentProfileBinding.inflate(inflater, container, false)
    return binding.root
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    binding.galleryButton.setOnClickListener {
      findNavController().navigate(R.id.action_profileFragment_to_galleryFragment)
    }
  }
}