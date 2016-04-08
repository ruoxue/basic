package xyz.ruoxue.opengl.ui.adapter.fragmentAdapter


import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import xyz.ruoxue.opengl.ui.fragment.BasicFragment

/**
 * Created by RuoxueYe on 2016/4/5.
 */
class BasicFragementAdapter : FragmentPagerAdapter {
    private var data: List<BasicFragment> ? = null

    constructor(fm: FragmentManager) : super(fm) {
    }

    constructor(fm: FragmentManager, data: List<BasicFragment>) : super(fm) {
        this.data = data
    }

    override fun getItem(position: Int): Fragment {
        return data!![position]
    }

    override fun getCount(): Int {
        return data!!.size

    }


}