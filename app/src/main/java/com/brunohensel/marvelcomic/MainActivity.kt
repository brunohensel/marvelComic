package com.brunohensel.marvelcomic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.brunohensel.marvelcomic.application.injector

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    injector.createFragmentFactory(activity = this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
}