package com.brunohensel.marvelcomic.di.modules

import androidx.fragment.app.FragmentFactory
import com.brunohensel.marvelcomic.di.multibindings.MultibindingFragmentFactory
import dagger.Binds
import dagger.Module

@Module
interface FragmentFactoryModule {

  @Binds
  fun bindFragmentFactory(impl: MultibindingFragmentFactory): FragmentFactory
}