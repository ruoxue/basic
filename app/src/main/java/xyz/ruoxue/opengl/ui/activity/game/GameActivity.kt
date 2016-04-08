package xyz.ruoxue.opengl.ui.activity.game

import android.os.Bundle
import com.pawegio.kandroid.find
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.activity.BasicActivity
import xyz.ruoxue.opengl.ui.customview.GameSurfaceView
import xyz.ruoxue.opengl.ui.presenter.game.GamePresenter
import xyz.ruoxue.opengl.ui.view.home.GameViewI

class GameActivity : BasicActivity(), GameViewI {


    private var gamePresenter: GamePresenter?? = null

    private val game: GameSurfaceView by lazy { find<GameSurfaceView>(R.id.gsv_game) }


    override fun initData() {
        isBack(true)
        setCustomeTitle(R.string.game)


    }

    override fun initEvent() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_game)

        gamePresenter = GamePresenter(this)
    }
}
