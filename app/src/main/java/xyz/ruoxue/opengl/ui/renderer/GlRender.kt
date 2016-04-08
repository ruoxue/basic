package xyz.ruoxue.opengl.ui.renderer

import android.opengl.GLSurfaceView
import android.opengl.GLU
import javax.microedition.khronos.egl.EGLConfig
import javax.microedition.khronos.opengles.GL10

/**
 * Created by RuoxueYe on 2016/4/6.
 */
class GlRender(var openGl: IOpenGL) : GLSurfaceView.Renderer {




    override fun onSurfaceCreated(gl: GL10, config: EGLConfig) {


        gl.glClearColor(1f, 0f, 0f, .5f)

        gl.glShadeModel(GL10.GL_SMOOTH)


        gl.glClearDepthf(1f)

        gl.glEnable(GL10.GL_DEPTH_TEST)

        gl.glDepthFunc(GL10.GL_LEQUAL)




        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST)


    }

    override fun onSurfaceChanged(gl: GL10, width: Int, height: Int) {
        gl.glViewport(0, 0, width, height)
        gl.glMatrixMode(GL10.GL_PROJECTION)
        gl.glLoadIdentity()
        GLU.gluPerspective(gl,45f,width.toFloat()/height.toFloat(),0.1f,100f)
        gl.glMatrixMode(GL10.GL_MODELVIEW)
        gl.glLoadIdentity()

    }

    override fun onDrawFrame(gl: GL10) {

        openGl.DrawScene(gl)
    }
}
