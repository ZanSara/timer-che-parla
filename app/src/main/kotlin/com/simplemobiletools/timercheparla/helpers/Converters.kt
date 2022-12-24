package com.simplemobiletools.timercheparla.helpers

import androidx.room.TypeConverter
import com.simplemobiletools.timercheparla.extensions.gson.gson
import com.simplemobiletools.timercheparla.models.StateWrapper
import com.simplemobiletools.timercheparla.models.TimerState

class Converters {

    @TypeConverter
    fun jsonToTimerState(value: String): TimerState {
        return try {
            gson.fromJson(value, StateWrapper::class.java).state
        } catch (e: Exception) {
            TimerState.Idle
        }
    }

    @TypeConverter
    fun timerStateToJson(state: TimerState) = gson.toJson(StateWrapper(state))
}
