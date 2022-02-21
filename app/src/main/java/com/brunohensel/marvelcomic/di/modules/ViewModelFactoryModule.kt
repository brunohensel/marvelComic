package com.brunohensel.marvelcomic.di.modules

import com.brunohensel.marvelcomic.di.multibindings.MultibindingViewModelFactory
import com.brunohensel.utils.viewmodel.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

  @Binds
  fun bindViewModelProvider(provider: MultibindingViewModelFactory): ViewModelProvider
}