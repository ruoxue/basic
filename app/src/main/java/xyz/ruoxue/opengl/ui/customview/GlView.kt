package xyz.ruoxue.opengl.ui.customview

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import xyz.ruoxue.opengl.ui.renderer.GlRender
import xyz.ruoxue.opengl.ui.renderer.IOpenGL

/**
 * Created by RuoxueYe on 2016/4/6.
 */
class GlView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : GLSurfaceView(context, attrs) {

init {
    if(context is IOpenGL)
    setRenderer(GlRender(context))
}
}
