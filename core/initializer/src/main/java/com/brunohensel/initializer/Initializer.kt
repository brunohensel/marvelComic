package com.brunohensel.initializer

import android.app.Application

interface Initializer {

  fun init(app: Application)
}