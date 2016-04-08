package xyz.ruoxue.opengl.ui.customview

import android.content.Context
import android.opengl.GLSurfaceView
import android.util.AttributeSet
import android.view.MotionEvent
import xyz.ruoxue.opengl.ui.renderer.GameRenderer

/**
 * Created by RuoxueYe on 2016/4/5.
 */
class GameSurfaceView
/**
 * Standard View constructor. In order to render something, you
 * must call [.setRenderer] to register a renderer.

 * @param context
 * *
 * @param attrs
 */
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : GLSurfaceView(context, attrs) {
    private val render = GameRenderer()

    init {
        setRenderer(render)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        queueEvent {
            render.setColor(event.x / width, event.y / height, 1.0f)
            render.setAngle(event.y / 10)
        }
        return true
    }


}

