package xyz.ruoxue.opengl.ui.presenter.game

import xyz.ruoxue.opengl.ui.presenter.BasicPresenter
import xyz.ruoxue.opengl.ui.view.home.Game2ViewI
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import javax.microedition.khronos.opengles.GL10

/**
 * Created by RuoxueYe on 2016/4/6.
 */
class Game2Presenter(game2ViewI: Game2ViewI) : BasicPresenter(game2ViewI) {

    private var colors: FloatArray = floatArrayOf(

                -0.8f , -0.4f* 1.732f , 0.0f ,
                0.8f , -0.4f *1.732f , 0.0f ,
                0.0f , 0.4f * 1.732f , 0.0f
            ,0.4f, 0.4f * 1.732f, 0.0f
               /*blue*/
    )  /*magenta*/

    private var colorBuffer: FloatBuffer? = null
    private var vbb: ByteBuffer = ByteBuffer.allocateDirect(colors.size * 4)
    fun initTra() {
        vbb.order(ByteOrder.nativeOrder())
        colorBuffer = vbb.asFloatBuffer()

        colorBuffer!!.put(colors)
        colorBuffer?.position(0)

    }
    fun DrawScene(gl: GL10) {

        initTra()



        gl.glColor4f(1f,0f,0f,.5f)

        gl.glPointSize(8f)
        gl.glLoadIdentity()

        gl.glTranslatef(0f,0f,-4f)

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)

        gl.glVertexPointer(3,GL10.GL_FLOAT,0,colorBuffer)

        gl.glDrawArrays(GL10.GL_POINTS,0,3)
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY)



    }


}