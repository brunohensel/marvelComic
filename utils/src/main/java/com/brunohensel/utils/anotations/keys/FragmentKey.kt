package com.brunohensel.utils.anotations.keys

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS
import kotlin.annotation.AnnotationTarget.FUNCTION
import kotlin.reflect.KClass

@Target(CLASS, FUNCTION)
@Retention(value = RUNTIME)
@MapKey
annotation class FragmentKey(val value: KClass<out Fragment>)
