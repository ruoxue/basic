package xyz.ruoxue.opengl.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.ruoxue.opengl.ui.view.BasicViewI

/**
 * Created by RuoxueYe on 2016/4/5.
 * 支持v4
 */
open abstract  class BasicFragment : Fragment(),BasicViewI {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }


    override fun onDestroy() {
        super.onDestroy()
    }

}