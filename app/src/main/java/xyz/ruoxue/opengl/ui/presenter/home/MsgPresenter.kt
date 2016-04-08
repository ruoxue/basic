package xyz.ruoxue.opengl.ui.presenter.home

import android.content.Context
import xyz.ruoxue.opengl.ui.modelInter.MsgModel
import xyz.ruoxue.opengl.ui.presenter.BasicPresenter
import xyz.ruoxue.opengl.ui.view.home.IMsgView

/**
 * Created by RuoxueYe on 2016/4/7.
 */
class MsgPresenter(msgVIew:IMsgView):BasicPresenter(msgVIew) {


    private var msgMode: MsgModel

    init {
        msgMode=MsgModel()
    }

    fun  getAdapter(ctx:Context){
        msgMode.getAdapter(ctx)


    }




}