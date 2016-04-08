package xyz.ruoxue.opengl.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import xyz.ruoxue.opengl.R
import xyz.ruoxue.opengl.ui.fragment.BasicFragment


class MeFragment : BasicFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_me, container, false)
    }

    companion object {
        fun newInstance(): MeFragment {
            val fragment = MeFragment()
            return fragment
        }
    }

}
