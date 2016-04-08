package xyz.ruoxue.opengl.ui.modelInter

import android.bluetooth.BluetoothAdapter
import android.content.Context
import xyz.ruoxue.opengl.ui.ModelImpl.BasicModeImpl

/**
 * Created by RuoxueYe on 2016/4/7.
 *
 *
 * 不想写接口了  ooi  太累
 */
class MsgModel : BasicModeImpl() {
    fun getAdapter(ctx: Context) {
        val bluetoothAdapter = BluetoothAdapter.getDefaultAdapter()


        bluetoothAdapter.bondedDevices


    }



    fun getData(callback: ICallBack ){//rx



        callback.get("111111")

    }


    interface  ICallBack{
        fun get(s:String)
    }


}