package xyz.ruoxue.opengl.ui.activity.game

import android.os.Bundle
import com.pawegio.kandroid.find
import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.activity.BasicActivity
import xyz.ruoxue.opengl.ui.customview.GlView
import xyz.ruoxue.opengl.ui.presenter.game.Game2Presenter
import xyz.ruoxue.opengl.ui.renderer.IOpenGL
import xyz.ruoxue.opengl.ui.view.home.Game2ViewI
import javax.microedition.khronos.opengles.GL10

class Game2Activity : BasicActivity(), Game2ViewI ,IOpenGL{
    override fun DrawScene(gl: GL10) {
        game2Presenter!!.DrawScene(gl)
    }


    private val gsvGame: GlView by lazy { find<GlView>(R.id.gsv_game) }
    private var game2Presenter: Game2Presenter? = null
    override fun initEvent() {
        isBack(true)
        setTitle(R.string.game)

    }

    override fun initData() {


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2)
        game2Presenter = Game2Presenter(this)
    }

    override fun onPause() {
        super.onPause()
        gsvGame.onPause()
    }

    override fun onResume() {
        super.onResume()
        gsvGame.onResume()
    }
}
