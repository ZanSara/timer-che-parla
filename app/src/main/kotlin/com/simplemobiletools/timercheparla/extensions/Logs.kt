package com.simplemobiletools.timercheparla.extensions

import android.util.Log
import com.simplemobiletools.timercheparla.BuildConfig

fun <A> A.log(tag: String)                = apply { if (BuildConfig.DEBUG) Log.wtf(tag, this.toString()) }
fun <A> A.log(first: String, tag: String) = apply { if (BuildConfig.DEBUG) Log.wtf(tag, first) }
