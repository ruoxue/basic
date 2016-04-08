package xyz.ruoxue.opengl.ui.ModelImpl

import android.content.Context
import com.pawegio.kandroid.connectivityManager
import xyz.ruoxue.opengl.ui.modelInter.BasicModelInter

/**
 * Created by RuoxueYe on 2016/4/5.
 */
open class BasicModeImpl : BasicModelInter {

    override fun isNetConn(context: Context): Boolean {

        val mNetworkInfo = context.connectivityManager.activeNetworkInfo
        if (mNetworkInfo != null) {
            return mNetworkInfo.isAvailable;
        }

        return false;

    }


}