package xyz.ruoxue.opengl.ui.presenter.home

import android.content.Intent
import xyz.ruoxue.opengl.ui.activity.game.Game2Activity
import xyz.ruoxue.opengl.ui.activity.game.GameActivity
import xyz.ruoxue.opengl.ui.fragment.home.HomeFragment
import xyz.ruoxue.opengl.ui.presenter.BasicPresenter
import xyz.ruoxue.opengl.ui.view.home.HomeFragementViewI

/**
 * Created by RuoxueYe on 2016/4/5.
 */
class HomeFragmentPresenter(homeFragementViewI: HomeFragementViewI) : BasicPresenter(homeFragementViewI) {

    fun tvHomeClick(position: Int, homeFragment: HomeFragment) {


        when (position) {
            0 -> {
                homeFragment.activity.startActivity(Intent(homeFragment.activity, GameActivity::class.java))
            }
            1 -> {
                homeFragment.activity.startActivity(Intent(homeFragment.activity, Game2Activity::class.java))
            }
        }


    }
}