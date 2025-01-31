package com.simplemobiletools.timercheparla.extensions

import java.util.concurrent.TimeUnit

val Int.secondsToMillis get() = TimeUnit.SECONDS.toMillis(this.toLong())
val Int.millisToSeconds get() = TimeUnit.MILLISECONDS.toSeconds(this.toLong())
