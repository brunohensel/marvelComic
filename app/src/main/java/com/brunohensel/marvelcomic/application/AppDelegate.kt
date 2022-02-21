package com.brunohensel.marvelcomic.application

import androidx.appcompat.app.AppCompatActivity
import com.brunohensel.marvelcomic.di.components.ActivityComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDelegate @Inject constructor(private val componentFactory: ActivityComponent.Factory) {

  fun createFragmentFactory(activity: AppCompatActivity) {
    val component = componentFactory.create(activity)
    val fragmentFactory = component.fragmentFactory
    activity.supportFragmentManager.fragmentFactory = fragmentFactory
  }
}