package com.brunohensel.logger

import com.brunohensel.initializer.Initializer
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
abstract class LoggerModule {

  @Binds
  @IntoSet
  internal abstract fun bindTimberInit(timberInitializer: TimberInitializer): Initializer
}