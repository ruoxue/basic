package xyz.ruoxue.opengl.ui.presenter.game

import xyz.ruoxue.opengl.ui.ModelImpl.game.Game3Mode
import xyz.ruoxue.opengl.ui.modelInter.IGame3Mode
import xyz.ruoxue.opengl.ui.presenter.BasicPresenter
import xyz.ruoxue.opengl.ui.view.game.IGameView

/**
 * Created by RuoxueYe on 2016/4/7.
 */
class Game3Presnter(gameView: IGameView) : BasicPresenter(gameView) {
    private val game3Mode: IGame3Mode
    init {
        game3Mode = Game3Mode()
    }






}