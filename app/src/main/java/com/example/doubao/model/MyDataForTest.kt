package com.example.doubao.model

import android.os.Parcelable
import java.lang.StringBuilder
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyDataForTest(val content: String, val customizedClass: CustomizedClass) : Parcelable

@Parcelize
// Each field needs to be parcelable/serializable
class CustomizedClass : Parcelable {
  val customizedField: String = "10"
  val somethingElse: StringBuilder = StringBuilder() // StringBuilder implemented Serializable.
}
