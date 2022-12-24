package com.simplemobiletools.timercheparla.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.simplemobiletools.timercheparla.fragments.TimerFragment
import com.simplemobiletools.commons.models.AlarmSound

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    private val fragments = HashMap<Int, Fragment>()

    override fun getItem(position: Int): Fragment {
        val fragment = getFragment(position)
        fragments[position] = fragment
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, item: Any) {
        fragments.remove(position)
        super.destroyItem(container, position, item)
    }

    override fun getCount() = 1

    private fun getFragment(position: Int) = when (position) {
        0 -> TimerFragment()
        else -> throw RuntimeException("Trying to fetch unknown fragment id $position")
    }

    fun updateTimerTabAlarmSound(alarmSound: AlarmSound) {
        (fragments[0] as? TimerFragment)?.updateAlarmSound(alarmSound)
    }

    fun updateTimerPosition(timerId: Int) {
        (fragments[0] as? TimerFragment)?.updatePosition(timerId)
    }
}
