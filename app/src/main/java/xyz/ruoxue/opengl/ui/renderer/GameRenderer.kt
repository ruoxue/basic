package xyz.ruoxue.opengl.ui.renderer

import android.opengl.GLSurfaceView
import android.util.Log
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.FloatBuffer
import java.nio.ShortBuffer
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by RuoxueYe on 2016/4/5.
 */
class GameRenderer : GLSurfaceView.Renderer {


    private var red: Float = 0.9f
    private var greed: Float = 0.2f
    private var blue: Float = 0.2f


    private var indexBuffer: ShortBuffer? = null;

    private var vertexBuffer: FloatBuffer? = null;

    private val indicesArray: ShortArray = shortArrayOf(0, 1, 2)

    private val nrOfVertices = 3


    /**
     * 三角形:绘制function
     */
    private fun initTriangle() {


        val vbb = ByteBuffer.allocateDirect(nrOfVertices * 3 * 4)
        vbb.order(ByteOrder.nativeOrder())
        vertexBuffer = vbb.asFloatBuffer()

        val ibb = ByteBuffer.allocateDirect(nrOfVertices * 2)
        ibb.order(ByteOrder.nativeOrder())
        indexBuffer = ibb.asShortBuffer()


        val coords: FloatArray = floatArrayOf(-.5f, -.5f, 0f,
                .5f, -.5f, 0f,
                0f, .5f, 0f
        )
        vertexBuffer!!.put(coords)

        indexBuffer!!.put(indicesArray)

        vertexBuffer!!.position(0)
        indexBuffer!!.position(0)


    }


    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY)
        initTriangle()

    }

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {

        gl.glViewport(0, 0, width, height)
    }

    override fun onDrawFrame(gl: GL10) {
        gl.glClearColor(red, greed, blue, 1.0f)
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT)

        gl.glColor4f(.5f, 0.5f, 0f, 0.5f)

        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer)
        gl.glDrawElements(GL10.GL_TRIANGLES, nrOfVertices, GL10.GL_UNSIGNED_SHORT, indexBuffer);

        gl.glRotatef(angle, 0f, 1f, 1f)

        gl.glColor4f(0.5f, 0f, 0f, 0.5f)

        Log.e("ruoxue", red.plus(greed).toString())
    }


    private var angle: Float = 0.0f


    fun setAngle(angle: Float) {
        this.angle = angle;
    }


    fun setColor(r: Float, g: Float, b: Float) {
        this.red = r;
        this.greed = g
        this.blue = b;

    }
}
