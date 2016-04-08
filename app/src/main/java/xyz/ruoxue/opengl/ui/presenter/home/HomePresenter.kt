package xyz.ruoxue.opengl.ui.presenter.home

import android.content.Context
import android.support.v7.app.ActionBar
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.presenter.BasicPresenter
import xyz.ruoxue.opengl.ui.view.home.HomeViewI

/**
 * Created by RuoxueYe on 2016/4/5.
 *
 *
 */
class HomePresenter(homeView: HomeViewI) : BasicPresenter(homeView) {



    init {


    }

    fun title(position: Int, supportActionBar: ActionBar, ctx: Context) {

        when (position) {
            0 -> {
                supportActionBar?.title = ctx.getString(R.string.home)
            }
            1 -> {
                supportActionBar?.title = ctx.getString(R.string.msg)
            }

            2 -> {
                supportActionBar?.title = ctx.getString(R.string.me)

            }

        }

    }


}