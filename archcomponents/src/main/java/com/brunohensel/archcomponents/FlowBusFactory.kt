package com.brunohensel.archcomponents

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class FlowBusFactory private constructor(val owner: LifecycleOwner) {

  companion object {

    private val buses = mutableMapOf<LifecycleOwner, FlowBusFactory>()

    @JvmStatic
    fun get(lifecycleOwner: LifecycleOwner): FlowBusFactory {
      return buses[lifecycleOwner]
        ?: FlowBusFactory(lifecycleOwner)
          .also { bus ->
            buses[lifecycleOwner] = bus
            lifecycleOwner.lifecycle.addObserver(bus.observer)
          }
    }
  }

  private val map = HashMap<Class<*>, Channel<*>>()
  private val observer = object : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
      map.forEach { entry -> entry.value.close() }
      buses.remove(owner)
    }
  }

  private fun <T> create(clazz: Class<T>): Channel<T> {
    val channel = Channel<T>()
    map[clazz] = channel
    return channel
  }

  fun <T : ComponentEvent> trySend(clazz: Class<T>, event: T) {
    val channel = map[clazz] ?: create(clazz)
    (channel as Channel<T>).trySend(event)
  }

  fun <T : ComponentEvent> getSafeManagedObservable(clazz: Class<T>): Flow<T> {
    val flow = map[clazz]?.receiveAsFlow() ?: create(clazz).receiveAsFlow()
    return flow as Flow<T>
  }
}