package xyz.ruoxue.opengl.ui.presenter

import xyz.ruoxue.opengl.ui.view.BasicViewI

/**
 * Created by RuoxueYe on 2016/4/5.
 * basicPresenter  主导器
 */
open class BasicPresenter(viewI: BasicViewI) {
    init {
        viewI.initData()
        viewI.initEvent()
    }

}