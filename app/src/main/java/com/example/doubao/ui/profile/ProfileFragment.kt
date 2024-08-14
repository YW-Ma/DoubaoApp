package com.example.doubao.ui.profile

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.PRIORITY_DEFAULT
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.doubao.MainActivity
import com.example.doubao.R
import com.example.doubao.databinding.FragmentProfileBinding
import com.example.doubao.model.MyDataForTest

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
    binding.listButton.setOnClickListener {
      findNavController().navigate(R.id.action_profileFragment_to_listFragment)
    }

    // For notification test:
    binding.notificationButton.setOnClickListener {
      setUpAndPostNotification()
    }
  }

  private fun setUpAndPostNotification() {
    val myDataForTest = MyDataForTest("Value in Intent")

    // Explicit Intent with Intent Extras (explicit means "provides the exact class to be run")
    val intent = Intent(activity, MainActivity::class.java).apply {
      putExtra("CUSTOM_DATA", myDataForTest)
      action = "OPEN_PROFILE_FRAGMENT"
    }

    // Wrap the Intent with a PendingIntent (A description of an Intent and target action to perform with it.)
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
      /*context=*/activity,
      0,
      intent,
      PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
    )

    // TODO: see how to set automatically dismiss
    val notification = NotificationCompat.Builder(requireContext(), "doubao_channel_id")
      .setSmallIcon(R.drawable.ic_launcher_foreground)
      .setContentTitle("Test Notification from Doubao")
      .setContentText("Click to open Profile with a customized string")
      .setPriority(PRIORITY_DEFAULT)
      .setContentIntent(pendingIntent)
      .setAutoCancel(true)
      .setTimeoutAfter(60000) // cancel after certain time (1min here).
      .build()

    with(NotificationManagerCompat.from(requireContext())) {
      if (ActivityCompat.checkSelfPermission(
          requireContext(),
          Manifest.permission.POST_NOTIFICATIONS
        ) != PackageManager.PERMISSION_GRANTED
      ) {
        // do nothing here because the post notificaiton should be granted.
        return@with
      }
      notify(1, notification)
    }
  }
}