package com.brunohensel.utils.anotations.scopes

import javax.inject.Scope
import kotlin.annotation.AnnotationRetention.RUNTIME

@Scope
@MustBeDocumented
@Retention(RUNTIME)
annotation class FragmentScope
