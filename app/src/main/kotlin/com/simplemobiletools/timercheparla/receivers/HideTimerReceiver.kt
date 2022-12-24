package com.simplemobiletools.timercheparla.receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.simplemobiletools.timercheparla.extensions.hideTimerNotification
import com.simplemobiletools.timercheparla.helpers.INVALID_TIMER_ID
import com.simplemobiletools.timercheparla.helpers.TIMER_ID
import com.simplemobiletools.timercheparla.models.TimerEvent
import org.greenrobot.eventbus.EventBus

class HideTimerReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val timerId = intent.getIntExtra(TIMER_ID, INVALID_TIMER_ID)
        context.hideTimerNotification(timerId)
        EventBus.getDefault().post(TimerEvent.Reset(timerId, ))
    }
}
