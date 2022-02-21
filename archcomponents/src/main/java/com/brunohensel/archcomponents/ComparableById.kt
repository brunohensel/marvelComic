package com.brunohensel.archcomponents

interface ComparableById {
  val idForComparison: Any

  fun getType(): Int {
    return 0
  }
}