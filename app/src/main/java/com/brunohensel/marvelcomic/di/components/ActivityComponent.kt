package com.brunohensel.marvelcomic.di.components

import android.app.Activity
import androidx.fragment.app.FragmentFactory
import com.brunohensel.marvelcomic.di.modules.FragmentFactoryModule
import com.brunohensel.marvelcomic.di.modules.FragmentModule
import com.brunohensel.utils.anotations.scopes.ActivityScope
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
  modules = [
    FragmentModule::class,
    FragmentFactoryModule::class
  ]
)
interface ActivityComponent {

  val fragmentFactory: FragmentFactory

  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance activity: Activity): ActivityComponent
  }
}