package xyz.ruoxue.opengl.ui.activity.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import xyz.ruoxue.opengl.R

/**
 * 启动页
 */
class LauncherActivity : AppCompatActivity() {


    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar!!.hide()
        setContentView(R.layout.activity_launcher)
        Thread(Runnable {
            Thread.sleep(1000)
            handler.sendEmptyMessage(0)
        }).start()
    }
}
