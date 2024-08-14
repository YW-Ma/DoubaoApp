package com.example.doubao

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_DEFAULT
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavGraphNavigator
import com.example.doubao.model.MyDataForTest
import com.example.doubao.ui.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // Adding a fragment programmatically. (if use navigation, then don't need and will cause bug)
    // supportFragmentManager.beginTransaction().add(R.id.root, ProfileFragment(), "CHILD_FRAGMENT").commitNow()

    // Create the notification channel
    createNotificationChannel(this)

    // check if the activity was started with an Intent that has the action "OPEN_PROFILE_FRAGMENT"
    if (intent?.action == "OPEN_PROFILE_FRAGMENT") {
      val myData = intent.getParcelableExtra("CUSTOM_DATA", MyDataForTest::class.java)
      if (myData != null) {
        Log.i("tag", "received not null myData! Success")
      } else {
        Log.i("tag", "received NULL myData!")
      }
    }
  }

  /** Create the doubao app channel for notification. */
  private fun createNotificationChannel(context: Context) {
    val channelId = "doubao_channel_id"
    val channelName = "Doubao"
    val channelDescription = "Doubao cat channel"
    val channel = NotificationChannel(channelId, channelName, IMPORTANCE_DEFAULT).apply {
      description = channelDescription
    }

    val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notificationManager.createNotificationChannel(channel)
  }
}