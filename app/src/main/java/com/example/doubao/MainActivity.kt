package com.example.doubao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.findNavController
import com.example.doubao.homescreen.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // Adding a fragment programmatically. (if use navigation, then don't need and will cause bug)
    // supportFragmentManager.beginTransaction().add(R.id.root, ProfileFragment(), "CHILD_FRAGMENT").commitNow()
  }
}