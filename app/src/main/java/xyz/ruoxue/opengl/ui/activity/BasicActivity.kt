package xyz.ruoxue.opengl.ui.activity

import android.R
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import xyz.ruoxue.opengl.ui.view.BasicViewI

/**
 * Created by RuoxueYe on 2016/4/5.
 *
 * 创建basicActivity class 抽象类
 * 返回键_______显示与事件
 *
 * 完全退出 事件
 *
 *
 */
abstract class BasicActivity : AppCompatActivity(), BasicViewI {
    val EXIT = "eixt";
    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            context.unregisterReceiver(this)
            if (context is BasicActivity)
                context.finish()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    fun isBack(flag: Boolean) {
        supportActionBar!!.setDisplayHomeAsUpEnabled(flag)
        supportActionBar!!.setHomeButtonEnabled(flag)


    }


    override fun onResume() {
        super.onResume()
        var filter = IntentFilter()
        filter.addAction(EXIT);
        registerReceiver(broadcastReceiver, filter);
    }

    fun close() {
        var intent = Intent();
        intent.setAction(EXIT); //
        sendBroadcast(intent);//
        finish();
    }


    fun setCustomeTitle(title: String) {
        setTitle(title)
    }

    fun setCustomeTitle(title: Int) {
        setTitle(title)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {

            R.id.home -> {
                finish()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStop() {
        try {
            unregisterReceiver(broadcastReceiver)
        } catch (e: RuntimeException) {
        }
        super.onStop()
    }

    override fun onDestroy() {

        super.onDestroy()
    }
}